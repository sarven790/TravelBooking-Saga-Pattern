namespace hotel_service.API.basemodel.response;

public class BaseResponse<T>
{
    public bool IsSuccess { get; set; }
    public T Data { get; set; }
    public string ExecutionDate { get; set; }
    public string Message { get; set; }
    public ErrorResponse Error { get; set; }

    public BaseResponse(bool isSuccess, T data)
    {
        IsSuccess = isSuccess;
        Data = data;
        ExecutionDate = DateTimeOffset.Now.ToString("O");
    }

    public BaseResponse(bool isSuccess, string message)
    {
        IsSuccess = isSuccess;
        Message = message;
        ExecutionDate = DateTimeOffset.Now.ToString("O");
    }

    public BaseResponse(bool isSuccess, ErrorResponse error)
    {
        IsSuccess = isSuccess;
        Error = error;
        ExecutionDate = DateTimeOffset.Now.ToString("O");
    }
    
}