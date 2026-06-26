class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Set<String> visit = new HashSet<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visit.contains(r + "," + c)) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c, visit));
                }
            }
        }

        return maxArea;

        
    }

    public int bfs(int[][] grid, int r, int c, Set<String> visit) {
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});

        visit.add(r + "," + c);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            int left = current[1] - 1;
            int right = current[1] + 1;

            int up = current[0] - 1;
            int down = current[0] + 1;

            if (up >= 0 && grid[up][col] == 1 && !visit.contains(up + "," + col)) {
                queue.offer(new int[]{up, col});
                visit.add(up + "," + col);
                area++;
            } 

            if ( down < grid.length && grid[down][col] == 1 && !visit.contains(down + "," + col)) {
                queue.offer(new int[]{down, col});
                visit.add(down + "," + col);
                area++;
            }

            if (left >= 0 && grid[row][left] == 1 && !visit.contains(row + "," + left)) {
                queue.offer(new int[]{row, left});
                visit.add(row + "," + left);
                area++;
            }

            if ( right < grid[0].length && grid[row][right] == 1 && !visit.contains(row + "," + right)) {
                queue.offer(new int[]{row, right});
                visit.add(row + "," + right);
                area++;
            }

        }

        return area;
    }
}
