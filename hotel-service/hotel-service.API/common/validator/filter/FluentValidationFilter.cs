using FluentValidation;
using FluentValidation.Results;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace hotel_service.API.filter;

public class FluentValidationFilter : IAsyncActionFilter
{
    private readonly IServiceProvider _serviceProvider;
    private readonly ValidationErrorHelper _validationErrorHelper;

    public FluentValidationFilter(
        IServiceProvider serviceProvider,
        ValidationErrorHelper validationErrorHelper)
    {
        _serviceProvider = serviceProvider;
        _validationErrorHelper = validationErrorHelper;
    }

    public async Task OnActionExecutionAsync(ActionExecutingContext context, ActionExecutionDelegate next)
    {
        foreach (var argument in context.ActionArguments.Values)
        {
            if (argument is null)
                continue;

            var validatorType = typeof(IValidator<>).MakeGenericType(argument.GetType());
            var validatorObj = _serviceProvider.GetService(validatorType);

            if (validatorObj is not IValidator validator)
                continue;

            var validationContext = new ValidationContext<object>(argument);
            ValidationResult validationResult = await validator.ValidateAsync(validationContext, context.HttpContext.RequestAborted);

            if (!validationResult.IsValid)
            {
                FillModelState(context, validationResult.Errors);

                var response = _validationErrorHelper.ToBaseResponse(context.ModelState);
                context.Result = new BadRequestObjectResult(response);
                return;
            }
        }

        await next();
    }

    private static void FillModelState(ActionExecutingContext context, List<ValidationFailure> failures)
    {
        foreach (var failure in failures)
        {
            var key = string.IsNullOrWhiteSpace(failure.PropertyName)
                ? string.Empty
                : failure.PropertyName;

            context.ModelState.AddModelError(key, failure.ErrorMessage);
        }
    }
}