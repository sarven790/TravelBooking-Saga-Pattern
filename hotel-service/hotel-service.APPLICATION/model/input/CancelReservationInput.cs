namespace hotel_service.API.dto.request;

public class CancelReservationInput
{
    public string? HotelHoldId { get; set; }

    public CancelReservationInput(string? hotelHoldId)
    {
        HotelHoldId = hotelHoldId;
    }
    
}