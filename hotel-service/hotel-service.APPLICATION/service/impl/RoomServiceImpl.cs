using hotel_service.APPLICATION.model.input.builder;
using hotel_service.APPLICATION.model.output.builder;
using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;

namespace hotel_service.APPLICATION.service.impl;

public class RoomServiceImpl : IRoomService
{

    private readonly IRoomRepository<Room> _roomRepository;
    private readonly IHotelService _hotelService;

    public RoomServiceImpl(IRoomRepository<Room> roomRepository, IHotelService hotelService)
    {
        _roomRepository = roomRepository;
        _hotelService = hotelService;
    }
    
    public async Task<Room> AddRoom(RoomInput input)
    {
        int hotelId = await GetHotelIdByNameAsync(input.HotelName);
        return await _roomRepository.SaveAsync(input.ToEntity(hotelId, input.TypeIds));
    }

    private async Task<int> GetHotelIdByNameAsync(string? name, CancellationToken ct = default)
    {
        var hotel = await _hotelService.GetHotelIdByName(new HotelInputBuilder()
            .Name(name)
            .Build());
        return hotel.Id;
    }
    
}