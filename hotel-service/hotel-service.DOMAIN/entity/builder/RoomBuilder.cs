namespace hotel_service.DOMAIN.entity.builder;

public class RoomBuilder
{
    private readonly Room _room;

    public RoomBuilder()
    {
        _room = new Room();
    }

    public RoomBuilder RoomNo(string? roomNo)
    {
        _room.RoomNo = roomNo;
        return this;
    }

    public RoomBuilder Price(decimal price)
    {
        _room.Price = price;
        return this;
    }

    public RoomBuilder Capacity(int capacity)
    {
        _room.Capacity = capacity;
        return this;
    }

    public RoomBuilder HotelId(int hotelId)
    {
        _room.HotelId = hotelId;
        return this;
    }

    public RoomBuilder RoomRoomTypes(List<RoomRoomType> roomRoomTypes)
    {
        _room.RoomRoomTypes = roomRoomTypes;
        return this;
    }

    public Room Build()
    {
        return _room;
    }
    
}