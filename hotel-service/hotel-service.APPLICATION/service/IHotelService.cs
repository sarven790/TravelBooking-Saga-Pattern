using hotel_service.APPLICATION.model.input;

namespace hotel_service.APPLICATION.service;

public interface IHotelService
{
    Task AddHotel(HotelInput input);
}