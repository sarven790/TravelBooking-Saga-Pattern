using hotel_service.APPLICATION.model.enums;

namespace hotel_service.APPLICATION.model.output;

public class CreateReservationOutput
{
    public string? HotelHoldId { get; set; }
    public DateTime HoldExpiry { get; set; }
    public ReservationStatus ReservationStatus { get; set; }
}