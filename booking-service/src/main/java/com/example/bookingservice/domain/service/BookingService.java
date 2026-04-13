package com.example.bookingservice.domain.service;

import com.example.bookingservice.dao.entity.Booking;
import com.example.bookingservice.domain.model.input.InitInput;
import com.example.bookingservice.domain.model.input.UpdateStatusInput;

public interface BookingService {

    // init => ilk kaydı pending olarak atar.
    void init(InitInput input);

    //updateStatus => aşamalar sonucu statü güncellemesi yapar.
    void updateStatus(UpdateStatusInput input);

    void markFailed(String bookingId, String errorCode, String errorMessage);

    Booking getBookingByBookingId(String bookingId);

    //finalize => son statüyü belirler ve tüm işlemleri sonlandırır.


}
