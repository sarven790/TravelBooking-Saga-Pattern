using hotel_service.API.basemodel.response;
using hotel_service.API.exception;

namespace hotel_service.API.exception.errortype;

public enum UnhandledErrorTypeValue
{
    UNHANDLED_ERROR_TYPE
}

public sealed class UnhandledErrorType : IBaseErrorType
{
    public static readonly UnhandledErrorType UNHANDLED_ERROR_TYPE =
        new("Unhandled.Error");

    private readonly string _code;

    private UnhandledErrorType(string code)
    {
        _code = code;
    }

    public string GetCode() => _code;
}