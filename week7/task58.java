class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, explore(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int explore(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0; // Mark visited
        return 1
            + explore(grid, row + 1, col)
            + explore(grid, row - 1, col)
            + explore(grid, row, col + 1)
            + explore(grid, row, col - 1);
    }
}