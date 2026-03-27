using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.model.input;

public class HotelInput
{
    public string? Name { get; set; }
    public string? AddressLine { get; set; }
    public string? PhoneNumber { get; set; }
    public string? Email { get; set; }
    
    public string? CountryCode { get; set; }
    public int CityId { get; set; }
    public int DistrictId { get; set; }
    
    public Hotel ToEntity()
    {
        Hotel hotel = new Hotel();
        hotel.Name = Name;
        hotel.Detail = new HotelDetail(AddressLine,PhoneNumber,Email,CountryCode,CityId,DistrictId);
        return hotel;
    }
    
}