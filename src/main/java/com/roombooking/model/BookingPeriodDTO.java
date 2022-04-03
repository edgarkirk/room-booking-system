package com.roombooking.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BookingPeriodDTO {

    private Long id;
    private LocalDate fromDate;
    private LocalDate toDate;

    private Set<RoomDTO> rooms = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Set<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}
