package com.roombooking.service;

import com.roombooking.model.RoomDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Set<RoomDTO> checkAllAvailableRoomsForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public RoomDTO bookRoomForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }
}
