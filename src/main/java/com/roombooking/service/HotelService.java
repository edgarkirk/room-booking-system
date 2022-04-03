package com.roombooking.service;

import com.roombooking.model.RoomDTO;

import java.time.LocalDate;
import java.util.Set;

public interface HotelService {

    Set<RoomDTO> checkAllAvailableRoomsForPeriod(LocalDate fromDate, LocalDate toDate);
}
