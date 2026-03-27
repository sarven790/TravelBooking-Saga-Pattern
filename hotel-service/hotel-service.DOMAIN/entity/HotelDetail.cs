namespace hotel_service.DOMAIN.entity;

public class HotelDetail
{
    public int HotelId { get; set; }
    public Hotel? Hotel { get; set; }
    public DateTime CreatedAt { get; set; }
    public DateTime ModifiedAt { get; set; }
    
    public string? AddressLine { get; set; }
    public string? PhoneNumber { get; set; }
    public string? Email { get; set; }
    
    public string? CountryCode { get; set; }
    public Country? Country { get; set; }

    public int CityId { get; set; }
    public City? City { get; set; }

    public int DistrictId { get; set; }
    public District? District { get; set; }

    public HotelDetail(string? addressLine, string? phoneNumber, string? email, string? countryCode, int cityId,
        int districtId)
    {
        CreatedAt = DateTime.UtcNow;
        ModifiedAt = DateTime.UtcNow;
        AddressLine = addressLine;
        PhoneNumber = phoneNumber;
        Email = email;
        CountryCode = countryCode;
        CityId = cityId;
        DistrictId = districtId;
    }
    
}