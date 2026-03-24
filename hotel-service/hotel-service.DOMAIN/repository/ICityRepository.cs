using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface ICityRepository <T> : IRepository<T> where T : City
{
    Task<List<T>> SearchByNameAsync(string keyword, CancellationToken ct = default);
}