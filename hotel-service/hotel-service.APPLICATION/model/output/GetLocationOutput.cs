using hotel_service.API.dto.response;

namespace hotel_service.APPLICATION.model.output;

public class GetLocationOutput
{
    public List<GetLocationDto> GetLocationDtoList { get; set; }

    public GetLocationOutput(List<GetLocationDto> getLocationDtoList)
    {
        GetLocationDtoList = getLocationDtoList;
    }
    
}