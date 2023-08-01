package com.example.model;
import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int roomId;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", roomId=" + roomId + ", guestName=" + guestName
                + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
    }
}
