using hotel_service.API.dto.response;
using hotel_service.COMMON.model.enums;
using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.model.mapper;

public abstract class GetLocationOutputMapper
{
    public static List<GetLocationDto> ToCityMapper(List<City> cities)
    {
        return cities.Select(city => new GetLocationDto
        {
            Id = city.Id,
            Name = city.Name,
            Type = LocationType.CITY.ToString(),
            ParentId = city.CountryId,
            ParentName = city.Country?.Name,
            DisplayText = $"{city.Name}, {city.Country?.Name}"
        }).ToList();
    }

    public static List<GetLocationDto> ToDistrictMapper(List<District> districts)
    {
        return districts.Select(district => new GetLocationDto
        {
            Id = district.Id,
            Name = district.Name,
            Type = LocationType.DISTRICT.ToString(),
            ParentId = district.CityId,
            ParentName = district.City?.Name,
            DisplayText = $"{district.Name}, {district.City?.Name}, {district.City?.Country?.Name}"
        }).ToList();
    }
}