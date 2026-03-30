using hotel_service.API.basemodel.response;

namespace hotel_service.API.exception.errortype;

public sealed class HotelErrorType : IBaseErrorType
{

    private readonly string _name;
    private readonly string _code;

    public static readonly HotelErrorType HOTEL_NOT_FOUND = new("Hotel.Not.Found","HOTEL_NOT_FOUND");

    private HotelErrorType(string code,string name)
    {
        _name = name;
        _code = code;
    }
    
    public string GetCode() => _code;
    public string GetName() => _name;
}