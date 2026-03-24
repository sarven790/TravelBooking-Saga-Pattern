namespace hotel_service.DOMAIN.entity;

public class Hotel : BaseEntity
{
    public string? Name { get; set; }
    public string? Location { get; set; }
    public List<Room>? Rooms { get; set; }
} 