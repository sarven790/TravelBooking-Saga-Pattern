using hotel_service.DOMAIN.entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace hotel_service.INFRASTRUCTURE.data.config;

public class RoomRoomTypeConfig : IEntityTypeConfiguration<RoomRoomType>
{
    public void Configure(EntityTypeBuilder<RoomRoomType> builder)
    {
        builder.ToTable("room_room_type");

        builder.HasKey(x => new { x.RoomId, x.RoomTypeId });

        builder.Property(x => x.RoomId)
            .HasColumnName("room_id");

        builder.Property(x => x.RoomTypeId)
            .HasColumnName("room_type_id");

        builder.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .IsRequired();

        builder.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .IsRequired();

        builder.HasOne(x => x.Room)
            .WithMany(x => x.RoomRoomTypes)
            .HasForeignKey(x => x.RoomId)
            .OnDelete(DeleteBehavior.Cascade);

        builder.HasOne(x => x.RoomType)
            .WithMany(x => x.RoomRoomTypes)
            .HasForeignKey(x => x.RoomTypeId)
            .OnDelete(DeleteBehavior.Cascade);

        builder.HasIndex(x => x.RoomTypeId)
            .HasDatabaseName("idx_room_room_type_room_type_id");
    }
}