using hotel_service.API.localization;
using Microsoft.Extensions.Localization;

namespace hotel_service.API.util;

public static class MessageUtil
{
    public static string GetMessage(IStringLocalizer<SharedResource> l, string code)
    {
        return l[code].Value;
    }
}