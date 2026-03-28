namespace hotel_service.DOMAIN.entity;

public class CountryDto
{
    public int Id { get; set; }
    public string? Code { get; set; }
    public string? Name { get; set; }
    public CityDto City { get; set; }
}