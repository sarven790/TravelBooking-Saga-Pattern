using hotel_service.API.basemodel.response;

namespace hotel_service.API.exception;

public class BusinessException : Exception
{
    public IBaseErrorType ErrorType { get; }

    public BusinessException(IBaseErrorType errorType) : base(errorType.GetCode())
    {
        ErrorType = errorType;
    }
    
    
}