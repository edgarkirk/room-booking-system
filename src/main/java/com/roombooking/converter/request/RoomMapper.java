package com.roombooking.converter.request;

import com.roombooking.domain.BookingPeriod;
import com.roombooking.domain.Room;
import com.roombooking.model.BookingPeriodDTO;
import com.roombooking.model.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoomMapper {

    private final BookingPeriodMapper bookingPeriodMapper;

    public RoomMapper(BookingPeriodMapper bookingPeriodMapper) {
        this.bookingPeriodMapper = bookingPeriodMapper;
    }

    public Room map(RoomDTO roomDTO) {
        if (roomDTO == null) {
            return null;
        }
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setBookingPeriods(mapBookingPeriods(roomDTO.getBookingPeriods()));
        return room;
    }

    private Set<BookingPeriod> mapBookingPeriods(Set<BookingPeriodDTO> bookingPeriodDTOs) {
        return bookingPeriodDTOs.stream().map(bookingPeriodMapper::map).collect(Collectors.toSet());
    }
}
