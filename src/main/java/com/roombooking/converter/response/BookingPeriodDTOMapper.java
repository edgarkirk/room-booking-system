package com.roombooking.converter.response;

import com.roombooking.domain.BookingPeriod;
import com.roombooking.model.BookingPeriodDTO;
import org.springframework.stereotype.Component;

@Component
public class BookingPeriodDTOMapper {

    public BookingPeriodDTO map(BookingPeriod bookingPeriod) {
        if (bookingPeriod == null) {
            return null;
        }

        BookingPeriodDTO bookingPeriodDTO = new BookingPeriodDTO();
        bookingPeriodDTO.setId(bookingPeriod.getId());
        bookingPeriodDTO.setFromDate(bookingPeriod.getFromDate());
        bookingPeriodDTO.setToDate(bookingPeriod.getToDate());

        return bookingPeriodDTO;
    }
}
