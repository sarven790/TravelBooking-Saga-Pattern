using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using Microsoft.EntityFrameworkCore;

namespace hotel_service.INFRASTRUCTURE.repository;

public class CityRepository : ICityRepository<City>
{
    private readonly AppDbContext _db;

    public CityRepository(AppDbContext db)
    {
        _db = db;
    }

    public Task<List<City>> GetAllAsync(CancellationToken ct = default)
    {
        return _db.Cities.OrderByDescending(x => x.Id).ToListAsync(ct);
    }

    public Task<City?> GetByIdAsync(int id, CancellationToken ct = default)
    {
        return _db.Cities.FirstOrDefaultAsync(x => x.Id == id, ct);
    }

    public async Task<City> SaveAsync(City entity, CancellationToken ct = default)
    {
        _db.Add(entity);
        await _db.SaveChangesAsync(ct);
        return entity;
    }

    public async Task UpdateAsync(City entity, CancellationToken ct = default)
    {
        _db.Update(entity);
        await _db.SaveChangesAsync(ct);
    }

    public Task<List<City>> SearchByNameAsync(string keyword, CancellationToken ct = default)
    {
        return _db.Cities
            .Include(x => x.Country)
            .Where(x => x.Name != null && x.Name.ToLower().Contains(keyword))
            .OrderBy(x => x.Name)
            .ToListAsync(ct);
    }
}