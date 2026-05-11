class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Set<String> visit = new HashSet<>();
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visit.contains(r + "," + c)) {
                    bfs(grid, r, c, visit);
                    count += 1;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int r, int c, Set<String> visit) {
        
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});

        visit.add(r + "," + c);

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            int up = current[0] - 1;
            int down = current[0] + 1;
            int left = current[1] - 1;
            int right = current[1] + 1;

            if (up >= 0 && grid[up][col] == '1' && !visit.contains(up + "," + col)) {
                queue.offer(new int[]{up, col});
                visit.add(up + "," + col);
            } 
            if (down < grid.length && grid[down][col] == '1' && !visit.contains(down + "," + col)) {
                queue.offer(new int[]{down, col});
                visit.add(down + "," + col);
            } 
            if (left >= 0 && grid[row][left] == '1' && !visit.contains(row + "," + left)) {
                queue.offer(new int[]{row, left});
                visit.add(row + "," + left);
            }
            if (right < grid[0].length && grid[row][right] == '1' && !visit.contains(row + "," + right)) {
                queue.offer(new int[]{row, right});
                visit.add(row + "," + right);
            }
        }
    }
}
