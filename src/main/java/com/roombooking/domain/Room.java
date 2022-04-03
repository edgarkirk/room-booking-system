package com.roombooking.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@Table(name = "room")
public class Room extends BaseEntity {

    @Column(name = "room_number")
    private Integer roomNumber;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "room_booking_period",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "booking_period_id"))
    private SortedSet<BookingPeriod> bookingPeriods = new TreeSet<>();

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public SortedSet<BookingPeriod> getBookingPeriods() {
        return bookingPeriods;
    }

    public void setBookingPeriods(SortedSet<BookingPeriod> bookingPeriods) {
        this.bookingPeriods = bookingPeriods;
    }
}
