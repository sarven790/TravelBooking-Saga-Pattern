using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using Microsoft.EntityFrameworkCore;

namespace hotel_service.INFRASTRUCTURE.repository;

public class DistrictRepository : IDistrictRepository<District>
{
    private readonly AppDbContext _db;

    public DistrictRepository(AppDbContext db)
    {
        _db = db;
    }

    public Task<List<District>> GetAllAsync(CancellationToken ct = default)
    {
        return _db.Districts.OrderByDescending(x => x.Id).ToListAsync(ct);
    }

    public Task<District?> GetByIdAsync(int id, CancellationToken ct = default)
    {
        return _db.Districts.FirstOrDefaultAsync(x => x.Id == id, ct);
    }

    public async Task<District> SaveAsync(District entity, CancellationToken ct = default)
    {
        _db.Add(entity);
        await _db.SaveChangesAsync(ct);
        return entity;
    }

    public async Task UpdateAsync(District entity, CancellationToken ct = default)
    {
        _db.Update(entity);
        await _db.SaveChangesAsync(ct);
    }

    public Task<List<District>> SearchByNameAsync(string keyword, CancellationToken ct = default)
    {
        return _db.Districts
            .Include(x => x.City)
            .ThenInclude(x => x.Country)
            .Where(x => x.Name != null && x.Name.ToLower().Contains(keyword))
            .OrderBy(x => x.Name)
            .ToListAsync(ct);
    }
}