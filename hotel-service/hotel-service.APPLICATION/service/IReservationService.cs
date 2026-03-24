using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output;

namespace hotel_service.APPLICATION.service;

public interface IReservationService
{
    // hold-reservation => holdId, status ve holdExpiry döner
    CreateReservationOutput CreateReservation(CreateReservationInput input);

    // check-reservation

}