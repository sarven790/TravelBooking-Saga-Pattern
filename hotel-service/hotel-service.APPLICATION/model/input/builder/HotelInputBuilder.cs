namespace hotel_service.APPLICATION.model.input.builder;

public class HotelInputBuilder
{
    private readonly HotelInput _hotelInput;

    public HotelInputBuilder()
    {
        _hotelInput = new HotelInput();
    }

    public HotelInputBuilder Name(string? name)
    {
        _hotelInput.Name = name;
        return this;
    }

    public HotelInputBuilder AddressLine(string? addressLine)
    {
        _hotelInput.AddressLine = addressLine;
        return this;
    }

    public HotelInputBuilder PhoneNumber(string? phoneNumber)
    {
        _hotelInput.PhoneNumber = phoneNumber;
        return this;
    }

    public HotelInputBuilder Email(string? email)
    {
        _hotelInput.Email = email;
        return this;
    }

    public HotelInputBuilder CountryCode(string? countryCode)
    {
        _hotelInput.CountryCode = countryCode;
        return this;
    }

    public HotelInputBuilder CityId(int cityId)
    {
        _hotelInput.CityId = cityId;
        return this;
    }

    public HotelInputBuilder DistrictId(int districtId)
    {
        _hotelInput.DistrictId = districtId;
        return this;
    }

    public HotelInput Build()
    {
        return _hotelInput;
    }
    
}