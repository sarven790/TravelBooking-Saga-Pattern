using hotel_service.API.basemodel.response;
using hotel_service.API.basemodel.response.factory;
using hotel_service.API.exception.errortype;
using Microsoft.AspNetCore.Mvc.ModelBinding;

public class ValidationErrorHelper
{

    private readonly BaseResponseFactory _factory;

    public ValidationErrorHelper(BaseResponseFactory factory)
    {
        _factory = factory;
    }

    public BaseResponse<ErrorResponse> ToBaseResponse(ModelStateDictionary modelState)
    {
        var messageCode = modelState
            .Values
            .SelectMany(x => x.Errors)
            .Select(e => string.IsNullOrWhiteSpace(e.ErrorMessage) ? "Invalid value" : e.ErrorMessage)
            .Distinct()
            .FirstOrDefault("");
        return _factory.ResponseFail(messageCode, ValidationErrorType.FromCode(messageCode));
    }
}