using hotel_service.API.dto.request;
using hotel_service.APPLICATION.model.mapper;
using hotel_service.APPLICATION.model.output;

namespace hotel_service.APPLICATION.service.impl;

public class LocationServiceImpl : ILocationService
{

    private readonly ICityService _cityService;
    private readonly IDistrictService _districtService;

    public LocationServiceImpl(ICityService cityService, IDistrictService districtService )
    {
        _cityService = cityService;
        _districtService = districtService;
    }
    
    public async Task<GetLocationOutput> GetLocationList(LocationInput input)
    {
        var citiesOutput = await _cityService.SearchByNameAsync(input);
        var districtsOutput = await _districtService.SearchByNameAsync(input);
        
        var citiesLocationDtoList = GetLocationOutputMapper.ToCityMapper(citiesOutput.Cities);
        var districtLocationDtoList = GetLocationOutputMapper.ToDistrictMapper(districtsOutput.Districts);

        var concatDto = citiesLocationDtoList.Concat(districtLocationDtoList).ToList();

        return new GetLocationOutput(concatDto);
    }
    
    
}