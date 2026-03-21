using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output;

namespace hotel_service.APPLICATION.service;

public interface IHotelService
{
    Task AddHotel(HotelInput input);
    Task<HotelOutputId> GetHotelByName(HotelInput input);
}