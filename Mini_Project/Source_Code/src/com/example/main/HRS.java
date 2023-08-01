package com.example.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.example.dao.RoomDAO;
import com.example.dao.RoomDAOImpl;
import com.example.dao.BookingDAO;
import com.example.dao.BookingDAOImpl;
import com.example.model.Room;
import com.example.model.Booking;

public class HRS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        RoomDAO roomDao = new RoomDAOImpl();
        BookingDAO bookingDao = new BookingDAOImpl();

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. Manage bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Room> availableRooms = roomDao.getAvailableRooms();
                    System.out.println("Available Rooms:");
                    for (Room room : availableRooms) {
                        System.out.println(room);
                    }
                    break;
                case 2:
                    System.out.println("Enter guest name:");
                    String guestName = scanner.next();
                    System.out.println("Enter room type:");
                    String roomType = scanner.next();
                    System.out.println("Enter check-in date (yyyy-mm-dd):");
                    String checkInDateStr = scanner.next();
                    LocalDate checkInDate = LocalDate.parse(checkInDateStr);
                    System.out.println("Enter check-out date (yyyy-mm-dd):");
                    String checkOutDateStr = scanner.next();
                    LocalDate checkOutDate = LocalDate.parse(checkOutDateStr);

                    Room selectedRoom = roomDao.getAvailableRooms(roomType);
                    if (selectedRoom == null) {
                        System.out.println("No available rooms of type " + roomType);
                    } else {
                        Booking newBooking = new Booking();
                        newBooking.setGuestName(guestName);
                        newBooking.setRoomId(selectedRoom.getRoomId());
                        newBooking.setCheckInDate(checkInDate);
                        newBooking.setCheckOutDate(checkOutDate);
                        bookingDao.createBooking(newBooking);
                        roomDao.updateRoomAvailability(selectedRoom.getRoomId(), false);
                        System.out.println("Reservation successfully made.");
                    }
                    break;
                case 3:
                    System.out.println("1. View bookings by date");
                    System.out.println("2. View bookings by room");
                    System.out.println("3. View bookings by guest name");
                    System.out.println("4. Cancel booking");
                    System.out.print("Enter your choice: ");
                    int manageChoice = scanner.nextInt();
                    switch (manageChoice) {
                        case 1:
                            System.out.println("Enter date (yyyy-mm-dd):");
                            String dateStr = scanner.next();
                            LocalDate date = LocalDate.parse(dateStr);
                            List<Booking> bookingsByDate = bookingDao.getBookingsByDate(date);
                            System.out.println("Bookings for " + date + ":");
                            for (Booking booking : bookingsByDate) {
                                System.out.println(booking);
                            }
                            break;
                        case 2:
                            System.out.println("Enter room ID:");
                            int roomId = scanner.nextInt();
                            List<Booking> bookingsByRoom = bookingDao.getBookingsByRoom(roomId);
                            System.out.println("Bookings for Room ID " + roomId + ":");
                            for (Booking booking : bookingsByRoom) {
                                System.out.println(booking);
                            }
                            break;
                        case 3:
                            System.out.println("Enter guest name:");
                            String searchGuestName = scanner.next();
                            List<Booking> bookingsByGuestName = bookingDao.getBookingsByGuestName(searchGuestName);
                            System.out.println("Bookings for Guest Name " + searchGuestName + ":");
                            for (Booking booking : bookingsByGuestName) {
                                System.out.println(booking);
                            }
                            break;
                        case 4:
                            System.out.println("Enter booking ID to cancel:");
                            int cancelBookingId = scanner.nextInt();
                            Booking bookingToCancel = bookingDao.getBookingById(cancelBookingId);
                            if (bookingToCancel != null) {
                                bookingDao.cancelBooking(cancelBookingId);
                                roomDao.updateRoomAvailability(bookingToCancel.getRoomId(), true);
                                System.out.println("Booking successfully canceled.");
                            } else {
                                System.out.println("Booking not found.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Exiting Hotel Reservation System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
