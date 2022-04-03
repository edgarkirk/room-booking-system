package com.roombooking.model;

import java.util.HashSet;
import java.util.Set;

public class RoomDTO {

    private Long id;
    private Integer roomNumber;
    private Set<BookingPeriodDTO> bookingPeriods = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Set<BookingPeriodDTO> getBookingPeriods() {
        return bookingPeriods;
    }

    public void setBookingPeriods(Set<BookingPeriodDTO> bookingPeriods) {
        this.bookingPeriods = bookingPeriods;
    }
}
