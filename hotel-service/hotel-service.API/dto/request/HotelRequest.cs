using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.input.builder;

namespace hotel_service.API.dto.request;

public class HotelRequest
{
    public string? Name { get; set; }
    
    public string? AddressLine { get; set; }
    public string? PhoneNumber { get; set; }
    public string? Email { get; set; }
    
    public string? CountryCode { get; set; }
    public int CityId { get; set; }
    public int DistrictId { get; set; }

    public HotelInput ToInput()
    {
        return new HotelInputBuilder()
            .Name(Name)
            .AddressLine(AddressLine)
            .PhoneNumber(PhoneNumber)
            .Email(Email)
            .CountryCode(CountryCode)
            .CityId(CityId)
            .DistrictId(DistrictId)
            .Build();
    }
    
}