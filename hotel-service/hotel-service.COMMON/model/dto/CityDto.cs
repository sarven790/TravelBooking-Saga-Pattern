namespace hotel_service.DOMAIN.entity;

public class CityDto
{
    public int Id { get; set; }
    public string? Name { get; set; }
    public DistrictDto District { get; set; }
}