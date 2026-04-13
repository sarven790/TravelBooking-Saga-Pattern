using hotel_service.APPLICATION.model.enums;

namespace hotel_service.DOMAIN.entity;

public class Reservation : BaseEntity
{
    public int RoomId { get; set; }
    public string? HeldBy { get; set; }
    public string? HeldId { get; set; }
    public DateTime HoldUntil { get; set; }
    public string? HotelReservationId { get; set; }
    public ReservationStatus ReservationStatus { get; set; }
    
}