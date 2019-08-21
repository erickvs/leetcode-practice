package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int LAND = ' ';
    private static final int WATER = 'o';

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        // SETUP
        int rows = 40;
        int columns = 40;
        char[][] input = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                input[i][j] = ' ';
            }
        }
        int expected = 0;

        // EXECUTE
        solution.numIslands(input);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int numberOfIslands = 0;
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (grid[row][column] == LAND) {
                    numberOfIslands++;
                    bfs(grid, row, column);
                }
            }
        }
        return numberOfIslands;
    }

    private void bfs(char[][] grid, int row, int column) {
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        grid[row][column] = WATER;
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    if (isInvalid(grid, point[0] + direction[0], point[1] + direction[1])) continue;
                    queue.offer(new int[]{point[0] + direction[0], point[1] + direction[1]});
                    grid[point[0] + direction[0]][point[1] + direction[1]] = WATER;
                    display(grid);
                }
            }
        }
    }

    private boolean isInvalid(char[][] grid, int row, int column) {
        return row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == WATER;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == WATER) {
            return;
        }

        grid[r][c] = WATER;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private void display(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                sb.append(String.format(" %c", grid[row][col]));
            }
            sb.append("\n");
        }
        try {
            System.out.print(sb.toString());
            Thread.sleep(10);
        } catch (InterruptedException ex) {}
    }

    public void displayQueue(Queue<int[]> queue) {
        StringBuilder sb = new StringBuilder();
        int size = queue.size();
        List<int[]> l = (List<int[]>) queue;
        for(int[] point: l) {
            sb.append(String.format(" ->[%d,%d]%n", point[0], point[1]));
        }
        sb.append("END QUEUE\n\n");
        System.out.println(sb.toString());
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == LAND) {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    public int numIslandsWrong(char[][] grid) {
        int numberOfRows = grid.length;
        if (numberOfRows == 0) return 0;
        int numberOfColumns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int islandCount = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (grid[row][column] == LAND) {
                    islandCount++;
                    queue.offer(new int[]{row, column});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int[] point = queue.poll();
                            int currentRow = point[0];
                            int currentColumn = point[1];
                            grid[currentRow][currentColumn] = WATER;
                            for (int[] direction : DIRECTIONS) {
                                int newRow = currentRow + direction[0];
                                int newColumn = currentColumn + direction[1];
                                if (newRow < 0 || newRow >= numberOfRows || newColumn < 0 || newColumn >= numberOfColumns || grid[newRow][newColumn] == WATER) {
                                    continue;
                                }
                                queue.add(new int[]{newRow, newColumn});
                            }
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}
