package com.roombooking.bootstrap;

import com.roombooking.domain.BookingPeriod;
import com.roombooking.domain.Room;
import com.roombooking.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public DataLoader(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BookingPeriod bookingPeriod1 = new BookingPeriod();
        bookingPeriod1.setFromDate(LocalDate.of(2022, 4, 15));
        bookingPeriod1.setToDate(LocalDate.of(2022, 6, 20));

        BookingPeriod bookingPeriod2 = new BookingPeriod();
        bookingPeriod2.setFromDate(LocalDate.of(2022, 7, 13));
        bookingPeriod2.setToDate(LocalDate.of(2022, 7, 20));

        Room room = new Room();
        room.setRoomNumber(101);
        room.getBookingPeriods().add(bookingPeriod1);
        room.getBookingPeriods().add(bookingPeriod2);

        Room room2 = new Room();
        room2.setRoomNumber(102);
        room2.getBookingPeriods().add(bookingPeriod1);

        bookingPeriod1.getRooms().add(room);
        bookingPeriod1.getRooms().add(room2);

        bookingPeriod2.getRooms().add(room);

        Room savedRoom1 = roomRepository.save(room);
        Room savedRoom2 = roomRepository.save(room2);
    }
}
