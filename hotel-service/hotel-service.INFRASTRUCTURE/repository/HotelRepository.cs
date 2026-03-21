using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using Microsoft.EntityFrameworkCore;

namespace hotel_service.INFRASTRUCTURE.repository;

public class HotelRepository : IHotelRepository<Hotel>
{

    private readonly AppDbContext _db;

    public HotelRepository(AppDbContext db)
    {
        _db = db;
    }

    public Task<List<Hotel>> GetAllAsync(CancellationToken ct = default)
    {
        return _db.Hotels.OrderByDescending(x => x.Id).ToListAsync(ct);
    }

    public Task<Hotel?> GetByIdAsync(int id, CancellationToken ct = default)
    {
        return _db.Hotels.FirstOrDefaultAsync(x => x.Id == id, ct);
    }

    public async Task<Hotel> SaveAsync(Hotel entity, CancellationToken ct = default)
    {
        _db.Add(entity);
        await _db.SaveChangesAsync(ct);
        return entity;
    }

    public async Task UpdateAsync(Hotel entity, CancellationToken ct = default)
    {
        _db.Update(entity);
        await _db.SaveChangesAsync(ct);
    }

    public Task<Hotel?> GetHotelByNameAsync(string? Name, CancellationToken ct = default)
    {
        return _db.Hotels.FirstOrDefaultAsync(x => x.Name == Name, ct);
    }
}