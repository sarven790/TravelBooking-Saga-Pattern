namespace hotel_service.API.basemodel.response.builder;

public class BaseResponseBuilder
{
    public static BaseResponse<T> Build<T>(bool isSuccess, T data)
    {
        return new BaseResponse<T>(isSuccess, data);
    }

    public static BaseResponse<T> Build<T>(bool isSuccess, string message)
    {
        return new BaseResponse<T>(isSuccess, message);
    }

    public static BaseResponse<T> Build<T>(bool isSuccess, ErrorResponse error)
    {
        return new BaseResponse<T>(isSuccess, error);
    }

}