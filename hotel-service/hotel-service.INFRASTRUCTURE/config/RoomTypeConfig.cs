using hotel_service.DOMAIN.entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace hotel_service.INFRASTRUCTURE.data.config;

public class RoomTypeConfig : IEntityTypeConfiguration<RoomType>
{
    public void Configure(EntityTypeBuilder<RoomType> builder)
    {
        builder.ToTable("room_type");

        builder.HasKey(x => x.Id);

        builder.Property(x => x.Id)
            .HasColumnName("id");

        builder.Property(x => x.TypeName)
            .HasColumnName("room_type")
            .HasMaxLength(255);

        builder.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .IsRequired();

        builder.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .IsRequired();

        builder.HasMany(x => x.RoomRoomTypes)
            .WithOne(x => x.RoomType)
            .HasForeignKey(x => x.RoomTypeId)
            .OnDelete(DeleteBehavior.Cascade);
    }
}