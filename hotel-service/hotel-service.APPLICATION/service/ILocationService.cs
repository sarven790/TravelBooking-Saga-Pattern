using hotel_service.API.dto.request;
using hotel_service.API.dto.response;
using hotel_service.APPLICATION.model.output;

namespace hotel_service.APPLICATION.service;

public interface ILocationService
{
    Task<GetLocationOutput> GetLocationList(LocationInput input);
}