using hotel_service.COMMON.model.dto;
using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.model.mapper;

public abstract class HotelDtoMapper
{
    public static List<HotelDto> ToHotelMapper(List<Hotel> hotels)
    {
        return hotels.Select(hotel => new HotelDto
        {
            Name = hotel.Name,
            AddressLine = hotel.Detail?.AddressLine,
            PhoneNumber = hotel.Detail?.PhoneNumber,
            Email = hotel.Detail?.Email,
            Country = ToCountryDto(hotel.Detail.Country)
            
        }).ToList();
    }

    private static CountryDto ToCountryDto(Country country)
    {
        CountryDto countryDto = new CountryDto();
        countryDto.Id = country.Id;
        countryDto.Name = country.Name;
        countryDto.Code = country.Code;
        countryDto.City = ToCityDto(country.Cities);
        return countryDto;
    }

    private static CityDto ToCityDto(List<City> cities)
    {
        return cities.Select(city => new CityDto
        {
            Id = city.Id,
            Name = city.Name,
            District = ToDistrictDto(city.Districts)
        }).FirstOrDefault();
    }

    private static DistrictDto ToDistrictDto(List<District> districts)
    {
        return districts.Select(district => new DistrictDto
        {
            Id = district.Id,
            Name = district.Name
        }).FirstOrDefault();
    }

}