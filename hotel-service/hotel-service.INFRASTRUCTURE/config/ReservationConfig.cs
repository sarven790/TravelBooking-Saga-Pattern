using hotel_service.DOMAIN.entity;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace hotel_service.INFRASTRUCTURE.data.config;

public class ReservationConfig : IEntityTypeConfiguration<Reservation>
{
    public void Configure(EntityTypeBuilder<Reservation> builder)
    {
        builder.ToTable("reservation");

        builder.HasKey(x => x.Id);
        
        builder.Property(x => x.Id)
            .HasColumnName("id");

        builder.Property(x => x.RoomId)
            .HasColumnName("room_id")
            .IsRequired();

        builder.Property(x => x.HeldBy)
            .HasColumnName("held_by");

        builder.Property(x => x.HeldId)
            .HasColumnName("held_id");

        builder.Property(x => x.HoldUntil)
            .HasColumnName("hold_until");

        builder.Property(x => x.HotelReservationId)
            .HasColumnName("hotel_reservation_id");
        
        builder.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .IsRequired();

        builder.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .IsRequired();
    }
}