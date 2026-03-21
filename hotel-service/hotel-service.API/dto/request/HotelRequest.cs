using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.input.builder;

namespace hotel_service.API.dto.request;

public class HotelRequest
{
    public string? Name { get; set; }

    public HotelInput ToInput()
    {
        return new HotelInputBuilder()
            .Name(Name)
            .Build();
    }
    
}