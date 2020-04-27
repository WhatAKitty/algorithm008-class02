/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 * @author WhatAKitty
 * @date 2020/04/27
 * @since 1.0.0
 **/
public class NumberOfIslands {


    /**
     * 审题：
     * 1. 四周默认全部为"水"
     * 可能解法：
     * 1. 深度优先遍历图
     * 2. 广度优先遍历图
     * 测试用例：
     * [] -> 0
     * [[]] -> 0
     * [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]] -> 1
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }

        int numIslands = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (row < 0 || col < 0 || row >= nr || col >= nc || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

}
