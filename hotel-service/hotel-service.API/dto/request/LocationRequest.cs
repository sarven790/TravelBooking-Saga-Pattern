
namespace hotel_service.API.dto.request;

public class LocationRequest
{
     public string? Keyword { get; set; }
    

     public LocationInput ToInput()
     {
         return new LocationInput(Keyword);
     }
}