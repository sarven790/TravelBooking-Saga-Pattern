using hotel_service.DOMAIN.entity;
using hotel_service.DOMAIN.repository;
using hotel_service.INFRASTRUCTURE.data;
using Microsoft.EntityFrameworkCore;

namespace hotel_service.INFRASTRUCTURE.repository;

public class CountryRepository : ICountryRepository<Country>
{
    
    private readonly AppDbContext _db;

    public CountryRepository(AppDbContext db)
    {
        _db = db;
    }
    
    public Task<List<Country>> GetAllAsync(CancellationToken ct = default)
    {
        return _db.Countries.OrderByDescending(x => x.Id).ToListAsync(ct);
    }

    public Task<Country?> GetByIdAsync(int id, CancellationToken ct = default)
    {
        return _db.Countries.FirstOrDefaultAsync(x => x.Id == id, ct);
    }

    public async Task<Country> SaveAsync(Country entity, CancellationToken ct = default)
    {
        _db.Add(entity);
        await _db.SaveChangesAsync(ct);
        return entity;
    }

    public async Task UpdateAsync(Country entity, CancellationToken ct = default)
    {
        _db.Update(entity);
        await _db.SaveChangesAsync(ct);
    }
}