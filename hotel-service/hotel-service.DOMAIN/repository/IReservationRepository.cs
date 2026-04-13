using hotel_service.DOMAIN.entity;

namespace hotel_service.DOMAIN.repository;

public interface IReservationRepository<T> : IRepository<T> where T : Reservation
{
    Task<T> GetByHeldId(string heldId, CancellationToken ct = default);
}