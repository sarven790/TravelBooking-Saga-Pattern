namespace hotel_service.APPLICATION.model.input;

public class HotelInputByName
{
    public string? Name { get; set; }
    public string? Location { get; set; }
    public string RoomCapacity { get; set; }
    public decimal MinPriceValue { get; set; }
    public decimal MaxPriceValue { get; set; }
}