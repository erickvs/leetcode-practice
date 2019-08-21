package medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int[][] DIRECTIONS = {
            {-1,  0},
            { 1,  0},
            { 0, -1},
            { 0,  1}
    };

    public void wallsAndGates(int[][] rooms) {
        // First check if the input is valid
        int numberOfRows = rooms.length;
        if (numberOfRows == 0) return;
        int numberOfColumns =  rooms[0].length;

        // Add all the gates to the queue. This is the starting point.
        // Instead of starting with each empty room and trying to figure out
        // what is the closest gate
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                if (rooms[row][col] == GATE) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        while(!queue.isEmpty()) {
            // Take out the first gate coordinates and process it.
            int[] point = queue.poll();
            int row = point[0];
            int column = point[1];

            // Each gate has 4 possible neighbors
            for(int[] direction: DIRECTIONS) {
                // extract a possible neighbors coordinate
                int newRow = row + direction[0];
                int newColumn = column + direction[1];

                // This checks if the computed neighbor is invalid, instead of valid. This is important because we
                // are accessing the indexes of rooms which could throw a null pointer exception... took me a minute
                // to figure out.
                if(newRow < 0 || newRow >= numberOfRows || newColumn < 0 || newColumn >= numberOfColumns
                        || rooms[newRow][newColumn] != EMPTY_ROOM) {
                    continue;
                }

                // At this point we know that the new coordinates are fine and that we are in an empty room
                // so we set it's value to the value of the previous room plus one.
                rooms[newRow][newColumn] = rooms[row][column] + 1;

                // We insert this new room into our queue so we can process it later.
                queue.offer(new int[]{newRow, newColumn});
            }
        }
    }
}
