namespace hotel_service.DOMAIN.entity;

public class RoomRoomType
{
    public int RoomId { get; set; }
    public Room? Room { get; set; }

    public int RoomTypeId { get; set; }
    public RoomType? RoomType { get; set; }

    public DateTime CreatedAt { get; set; }
    public DateTime ModifiedAt { get; set; }
    
    public RoomRoomType() {}

    public RoomRoomType(int roomTypeId)
    {
        RoomTypeId = roomTypeId;
    }

    public void SetCreated(DateTime utcNow) => CreatedAt = utcNow;
    public void SetModified(DateTime utcNow) => ModifiedAt = utcNow;
}