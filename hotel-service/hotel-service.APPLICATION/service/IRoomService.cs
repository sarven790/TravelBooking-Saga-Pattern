using hotel_service.APPLICATION.model.input;
using hotel_service.APPLICATION.model.output.builder;
using hotel_service.DOMAIN.entity;

namespace hotel_service.APPLICATION.service;

public interface IRoomService
{
    Task<Room> AddRoom(RoomInput input);
    Task UpdateRoomAvailable(RoomInputById input);
}