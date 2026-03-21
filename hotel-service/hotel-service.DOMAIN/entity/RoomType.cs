namespace hotel_service.DOMAIN.entity;

public class RoomType : BaseEntity
{
    public string? TypeName { get; set; }

    public List<RoomRoomType> RoomRoomTypes { get; set; } = new();
}