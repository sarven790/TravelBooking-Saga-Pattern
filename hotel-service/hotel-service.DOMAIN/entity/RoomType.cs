namespace hotel_service.DOMAIN.entity;

public class RoomType : BaseEntity
{
    public string? RoomName { get; set; }
    public int Capacity { get; set; }
    
    public int RoomId { get; set; }
    public Room? Room { get; set; } = null;
    
}