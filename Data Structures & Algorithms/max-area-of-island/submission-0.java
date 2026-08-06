class Solution {
    int[][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        vis = new int[grid.length][grid[0].length];
        for(int[] i : vis){
            Arrays.fill(i, -1);
        }

        int maxA = 0;
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == -1 && grid[i][j] == 1){
                    count = bfs(i, j, grid);
                    maxA = Math.max(maxA, count);
                }
            }
        }

        maxA = Math.max(maxA, count);

        return maxA;
    }

    public int bfs(int n, int m, int[][] grid){
        int count = 1;
        vis[n][m] = 1;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{n,m});

        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int k =0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                && vis[nr][nc] == -1 && grid[nr][nc] == 1){
                    count++;
                    vis[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return count;
    }


}
