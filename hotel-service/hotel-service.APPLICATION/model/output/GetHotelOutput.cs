using hotel_service.COMMON.model.dto;

namespace hotel_service.APPLICATION.model.output;

public class GetHotelOutput
{
    public List<HotelDto> Hotels { get; set; }

    public GetHotelOutput(List<HotelDto> hotels)
    {
        Hotels = hotels;
    }
}