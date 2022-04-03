package com.roombooking.converter.response;

import com.roombooking.domain.BookingPeriod;
import com.roombooking.domain.Room;
import com.roombooking.model.BookingPeriodDTO;
import com.roombooking.model.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoomDTOMapper {

    private final BookingPeriodDTOMapper bookingPeriodMapper;

    public RoomDTOMapper(BookingPeriodDTOMapper bookingPeriodMapper) {
        this.bookingPeriodMapper = bookingPeriodMapper;
    }


    public RoomDTO map(Room room) {
        if (room == null) {
            return null;
        }
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setBookingPeriods(mapBookingPeriods(room.getBookingPeriods()));
        return roomDTO;
    }

    private Set<BookingPeriodDTO> mapBookingPeriods(Set<BookingPeriod> bookingPeriods) {
        return bookingPeriods.stream().map(bookingPeriodMapper::map).collect(Collectors.toSet());
    }
}
