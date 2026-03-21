using hotel_service.APPLICATION.model.input.builder;
using hotel_service.APPLICATION.model.output.builder;

namespace hotel_service.API.dto.request;

public class RoomRequest
{
    public string? HotelName { get; set; }
    public string? RoomNo { get; set; }
    public decimal Price { get; set; }
    public int Capacity { get; set; }
    public List<int> TypeIds { get; set; }

    public RoomInput ToInput()
    {
        return new RoomInputBuilder()
            .HotelName(HotelName)
            .RoomNo(RoomNo)
            .Price(Price)
            .Capacity(Capacity)
            .TypeIds(TypeIds)
            .Build();
    }
    
}