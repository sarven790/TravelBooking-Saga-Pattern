using hotel_service.APPLICATION.model.output;

namespace hotel_service.API.dto.response;

public class GetLocationResponse
{
    public List<GetLocationDto> GetLocationDtoList { get; set; }
    
    private GetLocationResponse(GetLocationOutput output)
    {
        GetLocationDtoList = output.GetLocationDtoList;
    }

    public static GetLocationResponse ToResponse(GetLocationOutput output)
    {
       return new GetLocationResponse(output);
    }
}