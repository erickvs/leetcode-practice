package medium;

import java.util.*;

public class WallsAndGatesBruteForce {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        int numberOfColumns = rooms[0].length;
        int numberOfRows = rooms.length;
        for(int row = 0; row < numberOfRows; row++) {
            for(int column = 0; column < numberOfColumns; column++) {
                Room currentRoom = new Room(row, column, rooms[row][column], rooms);
                int nearestGateDistance = nearestGateBFS(currentRoom);
                rooms[row][column] = nearestGateDistance;
            }
        }
    }

    private int nearestGateBFS(Room root) {
        if (!root.isEmptyRoom()) {
            return root.getValue();
        }
        Queue<Room> queue = new LinkedList<>();
        Set<Room> visited = new HashSet<>();
        int distance = -1;
        queue.offer(root);
        visited.add(root);
        while(!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Room currentRoom = queue.peek();
                if(currentRoom.isGate()) {
                    return distance;
                }
                for(Room room: currentRoom.getNeighborRooms()) {
                    if(!visited.contains(room)) {
                        queue.offer(room);
                        visited.add(room);
                    }
                }
                queue.poll();
            }
        }
        return Integer.MAX_VALUE;
    }

    private class Room {
        private int row;
        private int column;
        private int value;
        private int[][] rooms;

        Room(int row, int column, int value, int[][] rooms) {
            this.row = row;
            this.column = column;
            this.value = value;
            this.rooms = rooms;
        }

        boolean isGate() {
            return this.value == 0;
        }

        boolean isEmptyRoom() {
            return this.value == Integer.MAX_VALUE;
        }

        int getRow() {
            return this.row;
        }

        int getColumn() {
            return this.column;
        }

        int getValue() {
            return this.value;
        }

        List<Room> getNeighborRooms() {
            List<Room> neighborRooms = new ArrayList<>();
            addRoomIfValid(neighborRooms,row - 1, column);
            addRoomIfValid(neighborRooms,row + 1, column);
            addRoomIfValid(neighborRooms,row, column - 1);
            addRoomIfValid(neighborRooms,row, column + 1);
            return neighborRooms;
        }

        private void addRoomIfValid(List<Room> neighborRooms, int newRow, int newColumn) {
            if(isValidRowColumnCombination(newRow, newColumn) && !isObstacle(newRow, newColumn)) {
                neighborRooms.add(new Room(newRow, newColumn, rooms[newRow][newColumn], rooms));
            }
        }

        private boolean isValidRowColumnCombination(int row, int column) {
            return column >= 0 && column < rooms[0].length && row >= 0 && row < rooms.length;
        }

        private boolean isObstacle(int row, int column) {
            return rooms[row][column] < 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return getRow() == room.getRow() &&
                    getColumn() == room.getColumn() &&
                    getValue() == room.getValue();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRow(), getColumn(), getValue());
        }
    }
}