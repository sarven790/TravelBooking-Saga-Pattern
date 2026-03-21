using hotel_service.APPLICATION.model.output.builder;

namespace hotel_service.APPLICATION.model.input.builder;

public class RoomInputBuilder
{
    private readonly RoomInput _roomInput;

    public RoomInputBuilder()
    {
        _roomInput = new RoomInput();
    }

    public RoomInputBuilder HotelName(string? hotelName)
    {
        _roomInput.HotelName = hotelName;
        return this;
    }

    public RoomInputBuilder RoomNo(string? roomNo)
    {
        _roomInput.RoomNo = roomNo;
        return this;
    }

    public RoomInputBuilder Price(decimal price)
    {
        _roomInput.Price = price;
        return this;
    }

    public RoomInputBuilder Capacity(int capacity)
    {
        _roomInput.Capacity = capacity;
        return this;
    }

    public RoomInputBuilder TypeIds(List<int> typeIds)
    {
        _roomInput.TypeIds = typeIds;
        return this;
    }

    public RoomInput Build()
    {
        return _roomInput;
    }
}