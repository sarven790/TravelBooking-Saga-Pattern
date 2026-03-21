using hotel_service.API.exception;
using hotel_service.API.exception.errortype;
using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output;
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

    public async Task<HotelOutputId> GetHotelByName(HotelInput input)
    {
        var entity = await _hotelRepository.GetHotelByNameAsync(input.Name);
        HotelOutputId output = new HotelOutputId();
        if (entity == null)
        {
            throw new BusinessException(HotelErrorType.HOTEL_NOT_FOUND);
        }
        output.Id = entity.Id;
        return output;
    }
}