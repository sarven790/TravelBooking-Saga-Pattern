using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface IRoomRepository<T> : IRepository<T> where T : Room
{
    
}