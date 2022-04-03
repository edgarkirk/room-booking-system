package com.roombooking.service;

import com.roombooking.converter.request.RoomMapper;
import com.roombooking.converter.response.RoomDTOMapper;
import com.roombooking.domain.Room;
import com.roombooking.model.RoomDTO;
import com.roombooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelAdministratorServiceImpl implements HotelAdministratorService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final RoomDTOMapper roomDTOMapper;

    public HotelAdministratorServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper, RoomDTOMapper roomDTOMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.roomDTOMapper = roomDTOMapper;
    }

    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) {
        Room room = roomMapper.map(roomDTO);
        Room savedRoom = roomRepository.save(room);
        return roomDTOMapper.map(savedRoom);
    }

    @Override
    public Set<RoomDTO> findAllRooms() {
        Set<Room> rooms = new HashSet<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms.stream().map(roomDTOMapper::map).collect(Collectors.toSet());
    }

    @Override
    public RoomDTO findRoomById(Long id) {
        Room room = roomRepository.findById(id).orElse(null);
        return roomDTOMapper.map(room);
    }

    @Override
    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        Optional<Room> optionalRoom = roomRepository.findById(id);

        if (optionalRoom.isEmpty()) {
            throw new RuntimeException("Room is missing");
        }
        Room room = roomMapper.map(roomDTO);
        Room savedRoom = roomRepository.save(room);

        return roomDTOMapper.map(savedRoom);
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Set<RoomDTO> checkAllBookedRoomsForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Set<RoomDTO> checkAllAvailableRoomsForPeriod(LocalDate fromDate, LocalDate toDate) {
        return null;
    }
}
