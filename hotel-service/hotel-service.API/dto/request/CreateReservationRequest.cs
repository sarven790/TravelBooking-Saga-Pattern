namespace hotel_service.APPLICATION.model.input;

public class CreateReservationRequest
{
    public string? UserId { get; set; }
    public int RoomId { get; set; }

    public CreateReservationInput ToInput()
    {
        CreateReservationInput createReservationInput = new CreateReservationInput();
        createReservationInput.UserId = UserId;
        createReservationInput.RoomId = RoomId;
        return createReservationInput;
    }
}