package com.example.bookingservice.dao.entity;

import com.example.bookingservice.common.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "booking", schema = "bookingservice")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity {

    // Temel bilgiler

    @Column(name = "booking_id", unique = true)
    private String bookingId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "total_amount", precision = 18, scale = 2)
    private BigDecimal totalAmount;

    // Pricing / Quote
    @Column(name = "quote_id", length = 100)
    private String quoteId;

    @Column(name = "quoted_total_amount", precision = 18, scale = 2)
    private BigDecimal quotedTotalAmount;

    @Column(name = "quote_expiry_at")
    private LocalDateTime quoteExpiryAt;

    // Payment
    @Column(name = "payment_auth_id", length = 100)
    private String paymentAuthId;

    @Column(name = "payment_capture_id", length = 100)
    private String paymentCaptureId;

    @Column(name = "payment_status", length = 50)
    private String paymentStatus;

    @Column(name = "payment_provider", length = 50)
    private String paymentProvider;

    // Flight
    @Column(name = "flight_hold_id", length = 100)
    private String flightHoldId;

    @Column(name = "flight_reservation_id", length = 100)
    private String flightReservationId;

    @Column(name = "flight_status", length = 50)
    private String flightStatus;

    // Hotel
    @Column(name = "hotel_hold_id", length = 100)
    private String hotelHoldId;

    @Column(name = "hotel_reservation_id", length = 100)
    private String hotelReservationId;

    @Column(name = "hotel_status", length = 50)
    private String hotelStatus;

    // Car
    @Column(name = "car_hold_id", length = 100)
    private String carHoldId;

    @Column(name = "car_reservation_id", length = 100)
    private String carReservationId;

    @Column(name = "car_status", length = 50)
    private String carStatus;

    // Workflow / Saga
    @Column(name = "workflow_id", length = 100)
    private String workflowId;

    @Column(name = "current_step", length = 50)
    private String currentStep;

    @Column(name = "retry_count")
    private Integer retryCount;

    @Column(name = "last_error_code", length = 100)
    private String lastErrorCode;

    @Column(name = "last_error_message", columnDefinition = "TEXT")
    private String lastErrorMessage;

    // Zaman bilgileri
    @Column(name = "hold_expiry_at")
    private LocalDateTime holdExpiryAt;

    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    // Metadata
    @Column(name = "channel", length = 50)
    private String channel;

    @Column(name = "locale", length = 20)
    private String locale;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Version
    @Column(name = "version")
    private Integer version;

}
