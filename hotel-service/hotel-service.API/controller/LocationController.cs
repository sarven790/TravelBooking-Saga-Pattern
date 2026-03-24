using hotel_service.API.basemodel.response;
using hotel_service.API.basemodel.response.factory;
using hotel_service.API.dto.request;
using hotel_service.API.dto.response;
using hotel_service.APPLICATION.service;
using Microsoft.AspNetCore.Mvc;

namespace hotel_service.API.controller;

[ApiController]
[Route("api/v1/location")]
public class LocationController : ControllerBase
{

    private readonly BaseResponseFactory _factory;
    private readonly ILocationService _locationService;

    public LocationController(BaseResponseFactory factory, ILocationService locationService)
    {
        _factory = factory;
        _locationService = locationService;
    }

    [HttpPost("get-list")]
    public async Task<BaseResponse<GetLocationResponse>> GetLocationList([FromBody] LocationRequest request)
    {
        var output = await _locationService.GetLocationList(request.ToInput());
        return _factory.ResponseSuccess(GetLocationResponse.ToResponse(output));
    }
    

}