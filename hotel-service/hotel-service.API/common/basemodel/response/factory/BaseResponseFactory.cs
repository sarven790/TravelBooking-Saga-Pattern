using hotel_service.API.basemodel.response.builder;
using hotel_service.API.localization;
using hotel_service.API.util;
using Microsoft.Extensions.Localization;

namespace hotel_service.API.basemodel.response.factory;

public class BaseResponseFactory
{
    private readonly IStringLocalizer<SharedResource> _l;
    public BaseResponseFactory(
        IStringLocalizer<SharedResource> l)
    {
        _l = l;
    }

    public BaseResponse<T> ResponseSuccess<T>(T data)
        => BaseResponseBuilder.Build(true, data);

    public BaseResponse<object> ResponseSuccess(string messageCode)
    {
        var message = MessageUtil.GetMessage(_l, messageCode);
        
        return BaseResponseBuilder.Build<object>(true, message);
    }

    public BaseResponse<ErrorResponse> ResponseFail(string messageCode, IBaseErrorType errorType)
    {
        var localized = _l[messageCode];
        var errorDescription = localized.Value;

        return BaseResponseBuilder.Build<ErrorResponse>(false, new ErrorResponse(errorType, errorDescription));
    }
}