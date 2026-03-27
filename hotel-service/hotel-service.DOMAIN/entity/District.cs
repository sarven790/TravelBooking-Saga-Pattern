namespace hotel_service.DOMAIN.entity;

public class District : BaseEntity
{
    public string? Name { get; set; }

    public int CityId { get; set; }
    public City? City { get; set; }
    public List<HotelDetail>? HotelDetails { get; set; }

}