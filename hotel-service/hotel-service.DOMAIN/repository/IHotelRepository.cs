using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface IHotelRepository<T> : IRepository<T> where T : Hotel
{
    Task<T?> GetHotelByNameAsync(string? name, CancellationToken ct = default);

    Task<List<T>> GetHotelList(string name, int districtId, decimal MinPriceValue, decimal MaxPriceValue,
        CancellationToken ct = default);
}