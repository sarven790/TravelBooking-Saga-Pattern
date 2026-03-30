namespace hotel_service.API.basemodel.response;

public class ErrorResponse
{
    public string ErrorStatus { get; set; }
    public string Description { get; set; }

    public ErrorResponse(string errorType, string description)
    {
        ErrorStatus = errorType;
        Description = description;
    }
    
}