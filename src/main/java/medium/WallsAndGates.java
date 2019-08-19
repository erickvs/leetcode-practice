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
        int numberOfRows = rooms.length;
        if (numberOfRows == 0) return;
        int numberOfColumns =  rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                if (rooms[row][col] == GATE) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int column = point[1];
            for(int[] direction: DIRECTIONS) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];
                if(newRow < 0 || newRow >= numberOfRows || newColumn < 0 || newColumn >= numberOfColumns
                        || rooms[newRow][newColumn] != EMPTY_ROOM) {
                    continue;
                }
                rooms[newRow][newColumn] = rooms[row][column] + 1;
                queue.offer(new int[]{newRow, newColumn});
            }
        }
    }
}
