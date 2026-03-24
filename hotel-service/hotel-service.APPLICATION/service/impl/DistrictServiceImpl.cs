using hotel_service.API.dto.request;
using hotel_service.APPLICATION.model.output;
using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;

namespace hotel_service.APPLICATION.service.impl;

public class DistrictServiceImpl : IDistrictService
{

    private readonly IDistrictRepository<District> _districtRepository;

    public DistrictServiceImpl(IDistrictRepository<District> districtRepository)
    {
        _districtRepository = districtRepository;
    }
    
    public async Task<DistrictListOutput> SearchByNameAsync(LocationInput input)
    {
        string keyword = input.Keyword.Trim().ToLower();
        var entityList = await _districtRepository.SearchByNameAsync(keyword);
        return new DistrictListOutput(entityList);
    }
}