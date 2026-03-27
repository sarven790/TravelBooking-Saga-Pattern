using hotel_service.DOMAIN.entity;

namespace hotel_service.INFRASTRUCTURE.data.config;

using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

public class HotelDetailConfig : IEntityTypeConfiguration<HotelDetail>
{
    public void Configure(EntityTypeBuilder<HotelDetail> builder)
    {
        builder.ToTable("hotel_detail");

        builder.HasKey(x => x.HotelId);

        builder.Property(x => x.HotelId)
            .HasColumnName("hotel_id");

        builder.Property(x => x.AddressLine)
            .HasColumnName("address_line")
            .HasMaxLength(500);

        builder.Property(x => x.PhoneNumber)
            .HasColumnName("phone_number")
            .HasMaxLength(255);

        builder.Property(x => x.Email)
            .HasColumnName("email")
            .HasColumnType("255");

        builder.Property(x => x.CountryCode)
            .HasColumnName("country_code")
            .HasMaxLength(4);

        builder.Property(x => x.CityId)
            .HasColumnName("city_id");

        builder.Property(x => x.DistrictId)
            .HasColumnName("district_id");

        builder.Property(x => x.CreatedAt)
            .HasColumnName("created_at")
            .IsRequired();

        builder.Property(x => x.ModifiedAt)
            .HasColumnName("modified_at")
            .IsRequired();

        builder.HasOne(x => x.Hotel)
            .WithOne(x => x.Detail)
            .HasForeignKey<HotelDetail>(x => x.HotelId)
            .OnDelete(DeleteBehavior.Cascade);
        
        builder.HasOne(x => x.Country)
            .WithMany(x => x.HotelDetails)
            .HasForeignKey(x => x.CountryCode)
            .HasPrincipalKey(x => x.Code)
            .OnDelete(DeleteBehavior.Restrict);

        builder.HasOne(x => x.City)
            .WithMany(x => x.HotelDetails)
            .HasForeignKey(x => x.CityId)
            .OnDelete(DeleteBehavior.Restrict);

        builder.HasOne(x => x.District)
            .WithMany(x => x.HotelDetails)
            .HasForeignKey(x => x.DistrictId)
            .OnDelete(DeleteBehavior.Restrict);
    }
}