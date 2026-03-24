namespace hotel_service.DOMAIN.entity;

public class City : BaseEntity
{
    public string? Name { get; set; }
    
    public int CountryId { get; set; }
    public Country? Country { get; set; }
    
    public List<District>? Districts { get; set; }
    
}