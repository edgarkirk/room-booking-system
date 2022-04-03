package com.roombooking.service;

import com.roombooking.model.RoomDTO;

import java.time.LocalDate;
import java.util.Set;

public interface HotelAdministratorService extends HotelService {

    RoomDTO saveRoom(RoomDTO roomDTO);

    Set<RoomDTO> findAllRooms();

    RoomDTO findRoomById(Long id);

    RoomDTO updateRoom(Long id, RoomDTO roomDTO);

    void deleteRoomById(Long id);

    Set<RoomDTO> checkAllBookedRoomsForPeriod(LocalDate fromDate, LocalDate toDate);
}
