using hotel_service.APPLICATION.model.enums;

namespace hotel_service.APPLICATION.model.output;

public class CreateReservationResponse
{
    public string? HotelHoldId { get; set; }
    public DateTime HoldExpiry { get; set; }
    public ReservationStatus ReservationStatus { get; set; }

    private CreateReservationResponse(CreateReservationOutput output)
    {
        HotelHoldId = output.HotelHoldId;
        HoldExpiry = output.HoldExpiry;
        ReservationStatus = output.ReservationStatus;
    }

    public static CreateReservationResponse ToResponse(CreateReservationOutput output)
    {
        return new CreateReservationResponse(output);
    }
}