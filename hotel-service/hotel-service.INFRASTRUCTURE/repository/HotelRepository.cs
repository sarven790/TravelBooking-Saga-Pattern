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

    public async Task<Hotel?> GetHotelByNameAsync(string? name, CancellationToken ct = default)
    {
        return await _db.Hotels.FirstOrDefaultAsync(x => x.Name == name, ct);
    }

    public async Task<List<Hotel>> GetHotelList(string name, int districtId, decimal MinPriceValue, decimal MaxPriceValue,
        CancellationToken ct = default)
    {
        var query = _db.Hotels
            .Include(x => x.Detail)
                .ThenInclude(d => d.City)
            .Include(x => x.Detail)
                .ThenInclude(d => d.District)
            .Include(x => x.Detail)
                .ThenInclude(d => d.Country)
            .Include(x => x.Rooms)
                .ThenInclude(d => d.RoomRoomTypes)
                    .ThenInclude(dd => dd.RoomType)
            .AsQueryable();

        if (!string.IsNullOrWhiteSpace(name))
        {
            query = query.Where(x => x.Name == name);
        }

        if (districtId > 0)
        {
            query = query.Where(x => x.Detail.DistrictId == districtId);
        }

        if (MinPriceValue > 0 && MaxPriceValue > 0)
        {
            query = query.Where(x => x.Rooms.Any(r => r.Price >= MinPriceValue && r.Price <= MaxPriceValue));
        }

        return await query.ToListAsync(ct);
    }
}