package com.roombooking.converter.request;

import com.roombooking.domain.BookingPeriod;
import com.roombooking.model.BookingPeriodDTO;
import org.springframework.stereotype.Component;

@Component
public class BookingPeriodMapper {

    public BookingPeriod map(BookingPeriodDTO bookingPeriodDTO) {
        if(bookingPeriodDTO == null) {
            return null;
        }

        BookingPeriod bookingPeriod = new BookingPeriod();
        bookingPeriod.setFromDate(bookingPeriodDTO.getFromDate());
        bookingPeriod.setToDate(bookingPeriodDTO.getToDate());

        return bookingPeriod;
    }
}
