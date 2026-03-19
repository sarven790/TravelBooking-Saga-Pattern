using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using Microsoft.EntityFrameworkCore;

namespace hotel_service.INFRASTRUCTURE.repository;

public class RoomRepository : IRoomRepository<Room>
{

    private readonly AppDbContext _db;

    public RoomRepository(AppDbContext db)
    {
        _db = db;
    }

    public Task<List<Room>> GetAllAsync(CancellationToken ct = default)
    {
        return _db.Rooms.OrderByDescending(x => x.Id).ToListAsync(ct);
    }

    public Task<Room?> GetByIdAsync(int id, CancellationToken ct = default)
    {
        return _db.Rooms.FirstOrDefaultAsync(x => x.Id == id, ct);
    }

    public async Task<Room> SaveAsync(Room entity, CancellationToken ct = default)
    {
        _db.Add(entity);
        await _db.SaveChangesAsync(ct);
        return entity;
    }

    public async Task UpdateAsync(Room entity, CancellationToken ct = default)
    {
        _db.Update(entity);
        await _db.SaveChangesAsync(ct);
    }
}