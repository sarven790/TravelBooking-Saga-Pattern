namespace hotel_service.DOMAIN.entity;

public class Country : BaseEntity
{
    public string? Code { get; set; }
    public string? Name { get; set; }
    
    public List<City>? Cities { get; set; }
    public List<HotelDetail>? HotelDetails { get; set; }

    
}