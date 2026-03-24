using hotel_service.APPLICATION.service;
using hotel_service.APPLICATION.service.impl;
using Microsoft.Extensions.DependencyInjection;

namespace hotel_service.APPLICATION;

public static class DependencyInjection
{
    public static IServiceCollection AddApplication(this IServiceCollection services)
    {
        services.AddScoped<IHotelService, HotelServiceImpl>();
        services.AddScoped<IRoomService, RoomServiceImpl>();
        services.AddScoped<IReservationService, ReservationServiceImpl>();
        services.AddScoped<ILocationService, LocationServiceImpl>();
        services.AddScoped<ICityService, CityServiceImpl>();
        services.AddScoped<IDistrictService, DistrictServiceImpl>();

        return services;
    }
}