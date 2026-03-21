using hotel_service.API.basemodel.response;

namespace hotel_service.API.exception.errortype;

public sealed class HotelErrorType : IBaseErrorType
{
    
    private readonly string _code;

    public static readonly HotelErrorType HOTEL_NOT_FOUND = new("Hotel.Not.Found");

    private HotelErrorType(string code)
    {
        _code = code;
    }
    
    public string GetCode() => _code;
}