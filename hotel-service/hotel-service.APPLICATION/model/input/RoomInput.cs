using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.entity.builder;

namespace hotel_service.APPLICATION.model.output.builder;

public class RoomInput
{
    public string? HotelName { get; set; }
    public string? RoomNo { get; set; }
    public decimal Price { get; set; }
    public int Capacity { get; set; }
    public List<int> TypeIds { get; set; }

    public Room ToEntity(int hotelId, List<int> typeIds)
    {
        return new RoomBuilder()
            .HotelId(hotelId)
            .RoomNo(RoomNo)
            .Price(Price)
            .Capacity(Capacity)
            .RoomRoomTypes(GetRoomRoomTypes(typeIds))
            .Build();
    }

    private List<RoomRoomType> GetRoomRoomTypes(List<int> typeIds)
    {
        List<RoomRoomType> roomRoomTypes = new List<RoomRoomType>();
        var now = DateTime.UtcNow;
        
        typeIds.ForEach(id =>
        {
            RoomRoomType roomRoomType = new RoomRoomType(id);
            roomRoomType.CreatedAt = now;
            roomRoomType.ModifiedAt = now;
            roomRoomTypes.Add(roomRoomType);
        });
        
        return roomRoomTypes;
    }
    
}