namespace hotel_service.DOMAIN.entity;

public class Room : BaseEntity
{
    public string? RoomNo { get; set; }
    public decimal Price { get; set; }
    
    public int HotelId { get; set; }
    public Hotel? Hotel { get; set; } = null;

    public List<RoomType> RoomTypes { get; set; }

}