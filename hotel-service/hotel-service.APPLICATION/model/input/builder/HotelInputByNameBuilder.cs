namespace hotel_service.APPLICATION.model.input.builder;

public class HotelInputByNameBuilder
{
    private readonly HotelInputByName _hotelInputByName;

    public HotelInputByNameBuilder()
    {
        _hotelInputByName = new HotelInputByName();
    }

    public HotelInputByNameBuilder Name(string name)
    {
        _hotelInputByName.Name = name;
        return this;
    }

    public HotelInputByNameBuilder DistrictId(int districtId)
    {
        _hotelInputByName.DistrictId = districtId;
        return this;
    }

    public HotelInputByNameBuilder MinPriceValue(decimal minPriceValue)
    {
        _hotelInputByName.MinPriceValue = minPriceValue;
        return this;
    }

    public HotelInputByNameBuilder MaxPriceValue(decimal maxPriceValue)
    {
        _hotelInputByName.MaxPriceValue = maxPriceValue;
        return this;
    }

    public HotelInputByName Build()
    {
        return _hotelInputByName;
    }
}