using hotel_service.API.dto.request;
using hotel_service.APPLICATION.model.output;

namespace hotel_service.APPLICATION.service;

public interface ICityService
{
    Task<CityListOutput> SearchByNameAsync(LocationInput input);
}