using hotel_service.DOMAIN.entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace hotel_service.INFRASTRUCTURE.config;

public class RoomConfig : IEntityTypeConfiguration<Room>
{
    public void Configure(EntityTypeBuilder<Room> entity)
    {
        entity.ToTable("room","hotelservice");

        entity.HasKey(x => x.Id);

        entity.Property(x => x.Id)
            .HasColumnName("id");

        // FK
        entity.Property(x => x.HotelId)
            .HasColumnName("hotel_id")
            .IsRequired();

        entity.Property(x => x.RoomNo)
            .HasColumnName("room_no")
            .HasMaxLength(20)
            .IsRequired();

        entity.Property(x => x.Price)
            .HasColumnName("price")
            .HasPrecision(12, 2)
            .IsRequired();
        
        entity.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .HasColumnType("timestamp with time zone")
            .IsRequired();
        
        entity.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .HasColumnType("timestamp with time zone")
            .IsRequired();

        // Relationship: Hotel 1 - N Room
        entity.HasOne(x => x.Hotel)
            .WithMany(h => h.Rooms)
            .HasForeignKey(x => x.HotelId)
            .OnDelete(DeleteBehavior.Cascade);
        
        // Relationship: Room 1 - N RoomType
        entity.HasMany(x => x.RoomTypes)
            .WithOne(r => r.Room)
            .HasForeignKey(r => r.RoomId)
            .OnDelete(DeleteBehavior.Cascade);

        // Indexes
        // Aynı otelde aynı room_no tekrar olmasın
        entity.HasIndex(x => new { x.HotelId, x.RoomNo })
            .IsUnique()
            .HasDatabaseName("ux_rooms_hotel_roomno");

        entity.HasIndex(x => x.Price)
            .HasDatabaseName("ix_rooms_price");

    }
}