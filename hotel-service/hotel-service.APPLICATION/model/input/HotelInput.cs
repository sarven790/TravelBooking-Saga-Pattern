using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.model.input;

public class HotelInput
{
    public string? Name { get; set; }

    public Hotel ToEntity()
    {
        Hotel hotel = new Hotel();
        hotel.Name = Name;
        return hotel;
    }
    
}