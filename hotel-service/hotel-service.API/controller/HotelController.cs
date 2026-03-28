using hotel_service.API.basemodel.response;
using hotel_service.API.basemodel.response.factory;
using hotel_service.API.constants;
using hotel_service.API.dto.request;
using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output;
using hotel_service.APPLICATION.service;
using Microsoft.AspNetCore.Mvc;

namespace hotel_service.API.controller;

[ApiController]
[Route("api/v1/hotel")]
public class HotelController : ControllerBase
{
    private readonly BaseResponseFactory _factory;
    private readonly IHotelService _hotelService;

    public HotelController(BaseResponseFactory factory, IHotelService hotelService)
    {
        _factory = factory;
        _hotelService = hotelService;
    }

    [HttpPost("add-hotel")]
    public async Task<BaseResponse<object>> AddHotel([FromBody] HotelRequest request)
    {
        await _hotelService.AddHotel(request.ToInput());
        return _factory.ResponseSuccess(MessageConstants.HotelAddSuccess);
    }

    [HttpPost("get-hotel")]
    public async Task<BaseResponse<GetHotelResponse>> GetHotelList([FromBody] HotelInputByName hotelInputByName)
    {
        var output = await _hotelService.GetHotelList(hotelInputByName);
        return _factory.ResponseSuccess(GetHotelResponse.ToResponse(output));
    }
    
}