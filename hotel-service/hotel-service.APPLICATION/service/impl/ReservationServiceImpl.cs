using hotel_service.API.dto.request;
using hotel_service.APPLICATION.model.enums;
using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output;
using hotel_service.APPLICATION.model.output.builder;
using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.entity.builder;
using hotel_service.DOMAIN.repository;

namespace hotel_service.APPLICATION.service.impl;

public class ReservationServiceImpl : IReservationService
{

    private readonly IRoomService _roomService;
    private readonly IReservationRepository<Reservation> _reservationRepository;

    public ReservationServiceImpl(IRoomService roomService, IReservationRepository<Reservation> reservationRepository)
    {
        _roomService = roomService;
        _reservationRepository = reservationRepository;
    }
    
    public async Task<CreateReservationOutput> CreateReservation(CreateReservationInput input)
    {
        // room id ile room tablosuna gidilip isAvailable statüsü false çekilir
        await _roomService.UpdateRoomAvailable(new RoomInputById(input.RoomId,false));

        // reservation servisine save atılır.
        string heldId = Guid.NewGuid().ToString();
        DateTime holdExpiry = DateTime.UtcNow;
        
        await _reservationRepository.SaveAsync(SetReservation(input, heldId, holdExpiry));

        return SetCreateReservationOutput(heldId, holdExpiry);
    }

    public async Task CancelReservation(CancelReservationInput input)
    {

        Reservation reservation = await _reservationRepository.GetByHeldId(input.HotelHoldId);
        
        await _roomService.UpdateRoomAvailable(new RoomInputById(reservation.RoomId,true));

        reservation.ReservationStatus = ReservationStatus.RESERVATION_CANCEL;

        await _reservationRepository.UpdateAsync(reservation);
    }

    private CreateReservationOutput SetCreateReservationOutput(string heldId, DateTime holdExpiry)
    {
        return new CreateReservationOutputBuilder()
            .HotelHoldId(heldId)
            .HoldExpiry(holdExpiry)
            .ReservationStatus(ReservationStatus.HOTEL_HELD)
            .Build();
    }

    private Reservation SetReservation(CreateReservationInput input, string heldId, DateTime holdExpiry)
    {
        return new ReservationBuilder()
            .RoomId(input.RoomId)
            .HeldBy(input.UserId)
            .HeldId(heldId)
            .HoldUntil(holdExpiry)
            .ReservationStatus(ReservationStatus.HOTEL_HELD)
            .Build();
    }
    
}