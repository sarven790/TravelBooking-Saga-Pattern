using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using hotel_service.INFRASTRUCTURE.interceptor;
using hotel_service.INFRASTRUCTURE.repository;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace hotel_service.INFRASTRUCTURE;

public static class DependencyInjection
{
    public static IServiceCollection AddInfrastructure(this IServiceCollection services, IConfiguration configuration)
    {
        var connectionString = configuration.GetConnectionString("Postgres");

        if (string.IsNullOrWhiteSpace(connectionString))
        {
            throw new InvalidOperationException(
                "Connection string 'Postgres' could not be found. Check hotel-service.API/appsettings.json and appsettings.Development.json");
        }

        services.AddScoped<AuditSaveChangesInterceptor>();

        services.AddDbContext<AppDbContext>((sp, options) =>
        {
            options.UseNpgsql(connectionString);
            options.AddInterceptors(sp.GetRequiredService<AuditSaveChangesInterceptor>());
        });

        services.AddScoped<IHotelRepository<Hotel>, HotelRepository>();
        services.AddScoped<IRoomRepository<Room>, RoomRepository>();
        services.AddScoped<ICountryRepository<Country>, CountryRepository>();
        services.AddScoped<ICityRepository<City>, CityRepository>();
        services.AddScoped<IDistrictRepository<District>, DistrictRepository>();
        services.AddScoped<IReservationRepository<Reservation>, ReservationRepository>();

        return services;
    }
}