using hotel_service.API.basemodel.response;

namespace hotel_service.API.exception.errortype;

public sealed class ValidationErrorType : IBaseErrorType
{
    private readonly string _code;
    
    public static readonly ValidationErrorType HOTEL_INVALID_PHONE_IS_REQURED = new("Hotel_Invalid.PhoneIs.Required");
    public static readonly ValidationErrorType HOTEL_INVALID_PHONE_FORMAT = new("Hotel_Invalid.Phone.Format");
    public static readonly ValidationErrorType HOTEL_INVALID_EMAIL_IS_REQURED = new("Hotel_Invalid.EmailIs.Required");
    public static readonly ValidationErrorType HOTEL_INVALID_EMAIL_FORMAT = new("Hotel_Invalid.Email.Format");
    public static readonly ValidationErrorType HOTEL_INVALID_EMAIL_LENGTH = new("Hotel_Invalid.Email.Length");

    public static ValidationErrorType FromCode(string code)
    {
        switch (code)
        {
            case "Hotel_Invalid.PhoneIs.Required":
                return HOTEL_INVALID_PHONE_IS_REQURED;
            case "Hotel_Invalid.Phone.Format":
                return HOTEL_INVALID_PHONE_FORMAT;
            case "Hotel_Invalid.EmailIs.Required":
                return HOTEL_INVALID_EMAIL_IS_REQURED;
            case "Hotel_Invalid.Email.Format":
                return HOTEL_INVALID_EMAIL_FORMAT;
            case "Hotel_Invalid.Email.Length":
                return HOTEL_INVALID_EMAIL_LENGTH;
            default:
                return HOTEL_INVALID_EMAIL_LENGTH;
                
        }
    }
    
    private ValidationErrorType(string code)
    {
        _code = code;
    }
    
    public string GetCode() => _code;
    
}