using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output;
using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.service;

public interface IHotelService
{
    Task AddHotel(HotelInput input);
    Task<HotelOutputId> GetHotelIdByName(HotelInput input);
    Task<GetHotelOutput> GetHotelList(HotelInputByName input);
}