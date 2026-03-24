using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.model.output;

public class DistrictListOutput
{
    public List<District> Districts { get; set; }

    public DistrictListOutput(List<District> districts)
    {
        Districts = districts;
    }
}