using System.Net;
using System.Text.Json;
using hotel_service.API.basemodel.response.factory;
using hotel_service.API.exception;
using hotel_service.API.exception.errortype;

namespace hotel_service.API.middleware;

public class ResponseExceptionMiddleware
{
    private readonly RequestDelegate _next;
    private readonly ILogger<ResponseExceptionMiddleware> _logger;

    public ResponseExceptionMiddleware(
        RequestDelegate next,
        ILogger<ResponseExceptionMiddleware> logger)
    {
        _next = next;
        _logger = logger;
    }

    public async Task Invoke(HttpContext context, BaseResponseFactory factory)
    {
        try
        {
            await _next(context);
        }
        catch (BusinessException be)
        {
            var code = be.ErrorType.GetCode();
            var type = be.ErrorType.GetName();
            _logger.LogError("BusinessException occurred: {Code}", code);

            var payload = factory.ResponseFail(code,type);
            await WriteAsJson(context, HttpStatusCode.OK, payload);
        }
        catch (Exception ex)
        {
            var err = UnhandledErrorType.UNHANDLED_ERROR_TYPE;
            _logger.LogError(ex, "UnhandledError occurred: {Code}", err.GetCode());

            var payload = factory.ResponseFail(err.GetCode(), err.GetName());
            await WriteAsJson(context, HttpStatusCode.InternalServerError, payload);
        }
    }

    private static Task WriteAsJson(HttpContext context, HttpStatusCode status, object payload)
    {
        context.Response.StatusCode = (int)status;
        context.Response.ContentType = "application/json";

        return context.Response.WriteAsync(JsonSerializer.Serialize(payload, new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        }));
    }
}