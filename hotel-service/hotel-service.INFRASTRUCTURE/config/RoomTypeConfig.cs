using hotel_service.DOMAIN.entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace hotel_service.INFRASTRUCTURE.config;

public class RoomTypeConfig : IEntityTypeConfiguration<RoomType>
{
    public void Configure(EntityTypeBuilder<RoomType> entity)
    {
        entity.ToTable("ROOM_TYPE","hotelservice");
        
        entity.Property(x => x.Id)
            .HasColumnName("id");

        entity.Property(x => x.RoomName)
            .HasColumnName("room_name")
            .HasMaxLength(200)
            .IsRequired();

        entity.Property(x => x.Capacity)
            .HasColumnName("capacity")
            .HasMaxLength(4)
            .IsRequired();
        
        entity.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .HasColumnType("timestamp with time zone")
            .IsRequired();
        
        entity.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .HasColumnType("timestamp with time zone")
            .IsRequired();

        // Relationship: Room 1 - N RoomType
        entity.HasOne(x => x.Room)
            .WithMany(h => h.RoomTypes)
            .HasForeignKey(x => x.RoomId)
            .OnDelete(DeleteBehavior.Cascade);

    }
}