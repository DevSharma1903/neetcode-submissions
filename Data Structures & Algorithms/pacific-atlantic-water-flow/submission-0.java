class Solution {
    List<int[]> atlantic;
    List<int[]> pacific;
    List<List<Integer>> ans;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        atlantic = new ArrayList<>();
        pacific = new ArrayList<>();
        ans = new ArrayList<>();

        for (int i = 0; i < heights[0].length; i++) {
            pacific.add(new int[]{0, i});
        }
        for (int i = 0; i < heights.length; i++) {
            pacific.add(new int[]{i, 0});
        }
        for (int i = 0; i < heights[0].length; i++) {
            atlantic.add(new int[]{heights.length - 1, i});
        }
        for (int i = 0; i < heights.length; i++) {
            atlantic.add(new int[]{i, heights[0].length - 1});
        }

        int n = heights.length;
        int m = heights[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bfs(i, j, heights);
            }
        }

        return ans;
    }

    public void bfs(int n, int m, int[][] heights) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        q.offer(new int[]{n, m});
        visited[n][m] = true;

        boolean p = false;
        boolean a = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (contains(pacific, n, m)) {
                p = true;
            }

            if (contains(atlantic, n, m)) {
                a = true;
            }

            int[] dr = {0, 0, -1, 1};
            int[] dc = {-1, 1, 0, 0};

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length) {
                    if (heights[nr][nc] <= heights[r][c]) {
                        if (contains(pacific, nr, nc)) {
                            p = true;
                        }

                        if (contains(atlantic, nr, nc)) {
                            a = true;
                        }

                        if (!visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        if (p == true && a == true) {
            ans.add(new ArrayList<>(List.of(n, m)));
        }
    }

    public boolean contains(List<int[]> list, int r, int c) {
        for (int[] cell : list) {
            if (cell[0] == r && cell[1] == c) {
                return true;
            }
        }
        return false;
    }
}