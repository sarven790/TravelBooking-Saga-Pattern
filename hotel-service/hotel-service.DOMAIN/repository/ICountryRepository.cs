using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface ICountryRepository<T> : IRepository<T> where T : Country
{
    
}