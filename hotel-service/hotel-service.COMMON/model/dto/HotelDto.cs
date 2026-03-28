using hotel_service.DOMAIN.entity;

namespace hotel_service.COMMON.model.dto;

public class HotelDto
{
    public string? Name { get; set; }
    public string? AddressLine { get; set; }
    public string? PhoneNumber { get; set; }
    public string? Email { get; set; }
    public CountryDto Country { get; set; }
    
}