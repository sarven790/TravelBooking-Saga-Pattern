namespace hotel_service.APPLICATION.model.input;

public class HotelInputByName
{
    public string Name { get; set; }
    public int DistrictId { get; set; }
    public decimal MinPriceValue { get; set; }
    public decimal MaxPriceValue { get; set; }
}