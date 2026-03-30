namespace hotel_service.COMMON.model.dto;

public class RoomDto
{
    public int Id { get; set; }
    public string? RoomNo { get; set; }
    public decimal Price { get; set; }
    public int Capacity { get; set; }
    public bool IsAvailable { get; set; }
    public List<string> RoomTypes { get; set; }
}