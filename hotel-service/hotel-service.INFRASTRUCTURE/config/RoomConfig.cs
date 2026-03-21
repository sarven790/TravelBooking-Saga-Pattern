using hotel_service.DOMAIN.entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace hotel_service.INFRASTRUCTURE.data.config;

public class RoomConfig : IEntityTypeConfiguration<Room>
{
    public void Configure(EntityTypeBuilder<Room> builder)
    {
        builder.ToTable("room");

        builder.HasKey(x => x.Id);

        builder.Property(x => x.Id)
            .HasColumnName("id");

        builder.Property(x => x.RoomNo)
            .HasColumnName("room_no")
            .HasMaxLength(100);

        builder.Property(x => x.Price)
            .HasColumnName("price")
            .HasColumnType("numeric(18,2)")
            .IsRequired();
        
        builder.Property(x => x.Capacity)
            .HasColumnName("capacity")
            .IsRequired();

        builder.Property(x => x.HotelId)
            .HasColumnName("hotel_id")
            .IsRequired();

        builder.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .IsRequired();

        builder.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .IsRequired();

        builder.HasOne(x => x.Hotel)
            .WithMany(x => x.Rooms)
            .HasForeignKey(x => x.HotelId)
            .OnDelete(DeleteBehavior.Cascade);

        builder.HasMany(x => x.RoomRoomTypes)
            .WithOne(x => x.Room)
            .HasForeignKey(x => x.RoomId)
            .OnDelete(DeleteBehavior.Cascade);
    }
}