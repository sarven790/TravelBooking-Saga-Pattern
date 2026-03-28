using hotel_service.APPLICATION.model.input.builder;

namespace hotel_service.APPLICATION.model.input;

public class HotelRequestByName
{
    public string Name { get; set; }
    public int DistrictId { get; set; }
    public decimal MinPriceValue { get; set; }
    public decimal MaxPriceValue { get; set; }

    public HotelInputByName ToInput()
    {
        return new HotelInputByNameBuilder()
            .Name(Name)
            .DistrictId(DistrictId)
            .MinPriceValue(MinPriceValue)
            .MaxPriceValue(MaxPriceValue)
            .Build();
    }
}