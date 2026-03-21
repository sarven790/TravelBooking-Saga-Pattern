using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface IHotelRepository<T> : IRepository<T> where T : Hotel
{
    Task<T?> GetHotelByNameAsync(string? Name, CancellationToken ct = default);
}