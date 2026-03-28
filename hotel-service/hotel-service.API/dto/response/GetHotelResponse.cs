using hotel_service.COMMON.model.dto;

namespace hotel_service.APPLICATION.model.output;

public class GetHotelResponse
{
    public List<HotelDto> Hotels { get; set; }

    private GetHotelResponse(GetHotelOutput output)
    {
        Hotels = output.Hotels;
    }

    public static GetHotelResponse ToResponse(GetHotelOutput output)
    {
        return new GetHotelResponse(output);
    }
    
}