using hotel_service.API.basemodel.response;
using hotel_service.API.basemodel.response.factory;
using hotel_service.API.constants;
using hotel_service.API.dto.request;
using hotel_service.APPLICATION.service;
using Microsoft.AspNetCore.Mvc;

namespace hotel_service.API.controller;

[ApiController]
[Route("api/v1/room")]
public class RoomController : ControllerBase
{

    private readonly BaseResponseFactory _factory;
    private readonly IRoomService _roomService;

    public RoomController(BaseResponseFactory factory, IRoomService roomService)
    {
        _factory = factory;
        _roomService = roomService;
    }
   
    [HttpPost("add-room")]
    public async Task<BaseResponse<object>> AddRoom([FromBody] RoomRequest request)
    {
        await _roomService.AddRoom(request.ToInput());
        return _factory.ResponseSuccess(MessageConstants.RoomAddSuccess);
    }

}