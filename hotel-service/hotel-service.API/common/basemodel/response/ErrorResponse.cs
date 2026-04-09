namespace hotel_service.API.basemodel.response;

public class ErrorResponse
{
    public string ErrorStatus { get; set; }
    public string ErrorDescription { get; set; }

    public ErrorResponse(string errorType, string errorDescription)
    {
        ErrorStatus = errorType;
        ErrorDescription = errorDescription;
    }
    
}