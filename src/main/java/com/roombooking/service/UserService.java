package com.roombooking.service;

import com.roombooking.model.RoomDTO;

import java.time.LocalDate;

public interface UserService extends HotelService {

    RoomDTO bookRoomForPeriod(LocalDate fromDate, LocalDate toDate);
}
