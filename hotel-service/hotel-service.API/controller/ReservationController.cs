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
[Route("api/v1/reservation")]
public class ReservationController
{
    private readonly BaseResponseFactory _factory;
    private readonly IReservationService _reservationService;

    public ReservationController(BaseResponseFactory factory, IReservationService reservationService)
    {
        _factory = factory;
        _reservationService = reservationService;
    }

    [HttpPost("create-reservation")]
    public async Task<BaseResponse<CreateReservationResponse>> CreateReservation([FromBody] CreateReservationRequest request)
    {
        var output = await _reservationService.CreateReservation(request.ToInput());
        return _factory.ResponseSuccess(CreateReservationResponse.ToResponse(output));
    }

    [HttpPost("cancel-reservation")]
    public async Task<BaseResponse<object>> CancelReservation([FromBody] CancelReservationRequest request)
    {
        await _reservationService.CancelReservation(new CancelReservationInput(request.HotelHoldId));
        return _factory.ResponseSuccess(MessageConstants.CancelReservation);
    }
    
}