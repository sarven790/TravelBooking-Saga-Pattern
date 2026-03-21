namespace hotel_service.APPLICATION.model.input.builder;

public class HotelInputBuilder
{
    private readonly HotelInput _hotelInput;

    public HotelInputBuilder()
    {
        _hotelInput = new HotelInput();
    }

    public HotelInputBuilder Name(string? name)
    {
        _hotelInput.Name = name;
        return this;
    }

    public HotelInput Build()
    {
        return _hotelInput;
    }
    
}