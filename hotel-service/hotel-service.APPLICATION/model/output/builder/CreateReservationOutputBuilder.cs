using hotel_service.APPLICATION.model.enums;

namespace hotel_service.APPLICATION.model.output.builder;

public class CreateReservationOutputBuilder
{
    private readonly CreateReservationOutput _createReservationOutput;

    public CreateReservationOutputBuilder()
    {
        _createReservationOutput = new CreateReservationOutput();
    }

    public CreateReservationOutputBuilder HotelHoldId(string hotelHoldId)
    {
        _createReservationOutput.HotelHoldId = hotelHoldId;
        return this;
    }

    public CreateReservationOutputBuilder HoldExpiry(DateTime holdExpiry)
    {
        _createReservationOutput.HoldExpiry = holdExpiry;
        return this;
    }

    public CreateReservationOutputBuilder ReservationStatus(ReservationStatus reservationStatus)
    {
        _createReservationOutput.ReservationStatus = reservationStatus;
        return this;
    }

    public CreateReservationOutput Build()
    {
        return _createReservationOutput;
    }
    
}