using hotel_service.API.basemodel.response.factory;
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
    
    

}