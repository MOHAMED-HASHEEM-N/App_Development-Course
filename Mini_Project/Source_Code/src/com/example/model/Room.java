package com.example.model;

public class Room {
    private int roomId;
    private String roomType;
    private boolean isAvailable;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomType=" + roomType + ", isAvailable=" + isAvailable + "]";
    }
}
