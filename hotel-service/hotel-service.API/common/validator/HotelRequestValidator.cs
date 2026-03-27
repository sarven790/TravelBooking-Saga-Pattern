using FluentValidation;
using hotel_service.API.dto.request;
using hotel_service.API.exception.errortype;

namespace hotel_service.API.common.validator;

public class HotelRequestValidator : AbstractValidator<HotelRequest>
{
    public HotelRequestValidator()
    {
        RuleFor(x => x.PhoneNumber)
            .NotEmpty().WithMessage(ValidationErrorType.HOTEL_INVALID_PHONE_IS_REQURED.GetCode())
            .Matches(@"^(\+90|90|0)?5\d{9}$")
            .WithMessage(ValidationErrorType.HOTEL_INVALID_PHONE_FORMAT.GetCode());

        RuleFor(x => x.Email)
            .NotEmpty().WithMessage(ValidationErrorType.HOTEL_INVALID_EMAIL_IS_REQURED.GetCode())
            .Matches(@"^[^\s@]+@[^\s@]+\.[^\s@]+$")
            .WithMessage(ValidationErrorType.HOTEL_INVALID_EMAIL_FORMAT.GetCode())
            .MaximumLength(255).WithMessage(ValidationErrorType.HOTEL_INVALID_EMAIL_LENGTH.GetCode());
    }
}