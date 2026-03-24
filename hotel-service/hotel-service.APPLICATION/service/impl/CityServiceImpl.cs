using hotel_service.API.dto.request;
using hotel_service.APPLICATION.model.output;
using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;

namespace hotel_service.APPLICATION.service.impl;

public class CityServiceImpl : ICityService
{

    private readonly ICityRepository<City> _cityRepository;

    public CityServiceImpl(ICityRepository<City> countryRepository)
    {
        _cityRepository = countryRepository;
    }
    
    public async Task<CityListOutput> SearchByNameAsync(LocationInput input)
    {
        string keyword = input.Keyword.Trim().ToLower();
        var entityList = await _cityRepository.SearchByNameAsync(keyword);
        return new CityListOutput(entityList);
    }
}