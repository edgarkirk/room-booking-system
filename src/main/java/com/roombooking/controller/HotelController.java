package com.roombooking.controller;

import com.roombooking.model.RoomDTO;
import com.roombooking.service.HotelAdministratorService;
import com.roombooking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelAdministratorService hotelAdministratorService;
    private final UserService userService;

    public HotelController(HotelAdministratorService hotelAdministratorService, UserService userService) {
        this.hotelAdministratorService = hotelAdministratorService;
        this.userService = userService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomDTO> saveRoom(@RequestBody RoomDTO roomDTO) {
        RoomDTO savedRoom = hotelAdministratorService.saveRoom(roomDTO);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @GetMapping("/rooms")
    public ResponseEntity<Set<RoomDTO>> getAllRooms() {
        Set<RoomDTO> rooms = hotelAdministratorService.findAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        RoomDTO room = hotelAdministratorService.findRoomById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
        RoomDTO room = hotelAdministratorService.updateRoom(id, roomDTO);
        return new ResponseEntity<>(room, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<RoomDTO> deleteRoom(@PathVariable Long id) {
      hotelAdministratorService.deleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
