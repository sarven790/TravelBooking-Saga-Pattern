
namespace hotel_service.API.dto.response;

public class GetLocationDto
{
    public int Id { get; set; }
    public string? Name { get; set; }
    public string Type { get; set; }
    public int ParentId { get; set; }
    public string? ParentName { get; set; }
    public string DisplayText { get; set; }
}