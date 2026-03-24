namespace hotel_service.DOMAIN.entity;

public abstract class BaseEntity
{
    public int Id { get; set; }
    public DateTime CreatedAt { get; set; }
    public DateTime ModifiedAt { get; set; }

    public void SetCreated(DateTime utcNow) => CreatedAt = utcNow;
    public void SetModified(DateTime utcNow) => ModifiedAt = utcNow;

}