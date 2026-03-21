namespace hotel_service.API.basemodel.response;

public class ErrorResponse
{
    public IBaseErrorType ErrorStatus { get; set; }
    public string Description { get; set; }

    public ErrorResponse(IBaseErrorType errorType, string description)
    {
        ErrorStatus = errorType;
        Description = description;
    }
    
}