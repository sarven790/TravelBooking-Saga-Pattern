namespace hotel_service.DOMAIN.entity.builder;

public class ReservationBuilder
{
    private readonly Reservation _reservation;

    public ReservationBuilder()
    {
        _reservation = new Reservation();
    }

    public ReservationBuilder RoomId(int roomId)
    {
        _reservation.RoomId = roomId;
        return this;
    }

    public ReservationBuilder HeldBy(string heldBy)
    {
        _reservation.HeldBy = heldBy;
        return this;
    }

    public ReservationBuilder HeldId(string heldId)
    {
        _reservation.HeldId = heldId;
        return this;
    }

    public ReservationBuilder HoldUntil(DateTime holdUntil)
    {
        _reservation.HoldUntil = holdUntil;
        return this;
    }

    public ReservationBuilder HotelReservationId(string hotelReservationId)
    {
        _reservation.HotelReservationId = hotelReservationId;
        return this;
    }

    public Reservation Build()
    {
        return _reservation;
    }
}