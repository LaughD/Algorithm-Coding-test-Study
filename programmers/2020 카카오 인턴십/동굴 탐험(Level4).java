/*
    Code written on Mar 30, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 카카오 인턴십: 동굴 탐험(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/67260
*/
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        ArrayDeque<Room> queue = new ArrayDeque<>();
        Room[] rooms = new Room[n];
        boolean[] visitedRooms = new boolean[n];

        for (int roomNumber = 0; roomNumber < n; roomNumber++)
            rooms[roomNumber] = new Room(roomNumber);

        for (int[] pt: path) {
            rooms[pt[0]].addConnectedRooms(rooms[pt[1]]);
            rooms[pt[1]].addConnectedRooms(rooms[pt[0]]);
        }

        for (int[] od: order) {
            rooms[od[0]].setBackRoom(rooms[od[1]]);
            rooms[od[1]].setFrontRoom(rooms[od[0]]);
        }

        if (rooms[0].getFrontRoom() != null)
            return false;

        queue.add(rooms[0]);
        while (!queue.isEmpty()) {
            Room room = queue.pollFirst();
            if (visitedRooms[room.getRoomNumber()])
                continue;
            visitedRooms[room.getRoomNumber()] = true;
            if (room.getBackRoom() != null)
                room.getBackRoom().setFrontRoom(null);
            for (Room connectedRoom: room.getConnectedRooms()) {
                if (connectedRoom.getParentRoom() == null)
                    connectedRoom.setParentRoom(room);
                if (connectedRoom.getFrontRoom() == null)
                    queue.addLast(connectedRoom);
            }
            if (room.getBackRoom() == null)
                continue;
            if (room.getBackRoom().getParentRoom() == null)
                continue;
            queue.addLast(room.getBackRoom());
        }

        for (boolean visitedRoom: visitedRooms)
            if (!visitedRoom)
                return false;
        return true;
    }
}

class Room {
    private final int roomNumber;
    private Room parentRoom;
    private Room frontRoom;
    private Room backRoom;
    private final ArrayList<Room> connectedRooms;

    public Room(int room) {
        this.roomNumber = room;
        this.parentRoom = null;
        this.frontRoom = null;
        this.backRoom = null;
        this.connectedRooms = new ArrayList<>();
    }

    public int getRoomNumber() { return roomNumber; }

    public Room getParentRoom() { return parentRoom; }
    
    public void setParentRoom(Room parentRoom) { this.parentRoom = parentRoom; }
    
    public Room getFrontRoom() { return frontRoom; }

    public void setFrontRoom(Room frontRoom) { this.frontRoom = frontRoom; }

    public Room getBackRoom() { return backRoom; }

    public void setBackRoom(Room backRoom) { this.backRoom = backRoom; }

    public ArrayList<Room> getConnectedRooms() { return connectedRooms; }

    public void addConnectedRooms(Room room) { this.connectedRooms.add(room); }
}
