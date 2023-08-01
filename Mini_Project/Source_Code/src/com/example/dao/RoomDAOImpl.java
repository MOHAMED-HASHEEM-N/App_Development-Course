package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.model.Room;
import com.example.util.DBHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAOImpl extends RoomDAO {

    @Override
    public List<Room> getAllRooms() {
        List<Room> roomList = new ArrayList<>();
        String query = "SELECT * FROM rooms";
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("roomId"));
                room.setRoomType(rs.getString("roomType"));
                room.setAvailable(rs.getBoolean("isAvailable"));
                roomList.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving all rooms: " + e.getMessage());
        }
        return roomList;
    }

    @Override
    public Room getRoomById(int roomId) {
        String query = "SELECT * FROM rooms WHERE roomId = ?";
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, roomId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Room room = new Room();
                    room.setRoomId(rs.getInt("roomId"));
                    room.setRoomType(rs.getString("roomType"));
                    room.setAvailable(rs.getBoolean("isAvailable"));
                    return room;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving room by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        String query = "SELECT * FROM rooms WHERE isAvailable = true";
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("roomId"));
                room.setRoomType(rs.getString("roomType"));
                room.setAvailable(true);
                availableRooms.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving available rooms: " + e.getMessage());
        }
        return availableRooms;
    }

    @Override
    public Room getAvailableRooms(String roomType) {
        String query = "SELECT * FROM rooms WHERE roomType = ? AND isAvailable = true";
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, roomType);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Room room = new Room();
                    room.setRoomId(rs.getInt("roomId"));
                    room.setRoomType(rs.getString("roomType"));
                    room.setAvailable(true);
                    return room;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving available room by type: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateRoomAvailability(int roomId, boolean isAvailable) {
        String query = "UPDATE rooms SET isAvailable = ? WHERE roomId = ?";
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setBoolean(1, isAvailable);
            ps.setInt(2, roomId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating room availability: " + e.getMessage());
        }
    }
}
