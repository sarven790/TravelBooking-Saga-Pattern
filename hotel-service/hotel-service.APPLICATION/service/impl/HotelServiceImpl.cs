using hotel_service.APPLICATION.model.input;
using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;

namespace hotel_service.APPLICATION.service.impl;

public class HotelServiceImpl : IHotelService
{

    private readonly IHotelRepository<Hotel> _hotelRepository;

    public HotelServiceImpl(IHotelRepository<Hotel> hotelRepo)
    {
        _hotelRepository = hotelRepo;
    }
    
    public async Task AddHotel(HotelInput input)
    {
        var entity = input.ToEntity();
        await _hotelRepository.SaveAsync(entity);
    }
}