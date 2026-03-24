using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface IDistrictRepository<T> : IRepository<T> where T : District
{
    Task<List<T>> SearchByNameAsync(string keyword, CancellationToken ct = default);
}