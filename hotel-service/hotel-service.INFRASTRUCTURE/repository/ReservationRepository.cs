using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using Microsoft.EntityFrameworkCore;

namespace hotel_service.INFRASTRUCTURE.repository;

public class ReservationRepository : IReservationRepository<Reservation>
{
    private readonly AppDbContext _db;

    public ReservationRepository(AppDbContext db)
    {
        _db = db;
    }

    public Task<List<Reservation>> GetAllAsync(CancellationToken ct = default)
    {
        return _db.Reservations.OrderByDescending(x => x.Id).ToListAsync(ct);
    }

    public Task<Reservation?> GetByIdAsync(int id, CancellationToken ct = default)
    {
        return _db.Reservations.FirstOrDefaultAsync(x => x.Id == id, ct);
    }

    public async Task<Reservation> SaveAsync(Reservation entity, CancellationToken ct = default)
    {
        _db.Add(entity);
        await _db.SaveChangesAsync(ct);
        return entity;
    }

    public async Task UpdateAsync(Reservation entity, CancellationToken ct = default)
    {
        await _db.SaveChangesAsync(ct);
    }

    public async Task<Reservation> GetByHeldId(string heldId, CancellationToken ct = default)
    {
        return await _db.Reservations.Where(x => x.HeldId == heldId)
            .FirstAsync(ct);
    }
}