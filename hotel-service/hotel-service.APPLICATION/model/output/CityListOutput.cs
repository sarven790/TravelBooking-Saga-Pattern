using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.model.output;

public class CityListOutput
{
    public List<City> Cities { get; set; }

    public CityListOutput(List<City> cities)
    {
        Cities = cities;
    }
}