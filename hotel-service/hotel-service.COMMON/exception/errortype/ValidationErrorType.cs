using hotel_service.API.basemodel.response;

namespace hotel_service.API.exception.errortype;

public sealed class ValidationErrorType : IBaseErrorType
{
    private readonly string _code;
    private readonly string _name;
    
    public static readonly ValidationErrorType HOTEL_INVALID_PHONE_IS_REQURED = new("Hotel_Invalid.PhoneIs.Required","HOTEL_INVALID_PHONE_IS_REQURED");
    public static readonly ValidationErrorType HOTEL_INVALID_PHONE_FORMAT = new("Hotel_Invalid.Phone.Format","HOTEL_INVALID_PHONE_FORMAT");
    public static readonly ValidationErrorType HOTEL_INVALID_EMAIL_IS_REQURED = new("Hotel_Invalid.EmailIs.Required","HOTEL_INVALID_EMAIL_IS_REQURED");
    public static readonly ValidationErrorType HOTEL_INVALID_EMAIL_FORMAT = new("Hotel_Invalid.Email.Format","HOTEL_INVALID_EMAIL_FORMAT");
    public static readonly ValidationErrorType HOTEL_INVALID_EMAIL_LENGTH = new("Hotel_Invalid.Email.Length","HOTEL_INVALID_EMAIL_LENGTH");

    public static string FromCode(string code)
    {
        switch (code)
        {
            case "Hotel_Invalid.PhoneIs.Required":
                return HOTEL_INVALID_PHONE_IS_REQURED._name;
            case "Hotel_Invalid.Phone.Format":
                return HOTEL_INVALID_PHONE_FORMAT._name;
            case "Hotel_Invalid.EmailIs.Required":
                return HOTEL_INVALID_EMAIL_IS_REQURED._name;
            case "Hotel_Invalid.Email.Format":
                return HOTEL_INVALID_EMAIL_FORMAT._name;
            case "Hotel_Invalid.Email.Length":
                return HOTEL_INVALID_EMAIL_LENGTH._name;
            default:
                return HOTEL_INVALID_EMAIL_LENGTH._name;
                
        }
    }
    
    private ValidationErrorType(string code,string name)
    {
        _code = code;
        _name = name;
    }
    
    public string GetCode() => _code;
    public string GetName() => _name;
}