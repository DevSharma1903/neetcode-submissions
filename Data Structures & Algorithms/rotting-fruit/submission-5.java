class Solution {
    int[][] vis;
    int fresh;
    int time;
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new int[n][m];
        fresh = 0;
        time = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        for(int[] i : vis){
            Arrays.fill(i, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == -1 && grid[i][j] == 2){
                    vis[i][j] = 1;
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};

        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            int t = p[2];

            for(int k=0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length
                    && vis[nr][nc]==-1&&grid[nr][nc]==1){
                        vis[nr][nc] = 1;
                        q.offer(new int[]{nr, nc, t+1});
                        time = Math.max(time, t + 1);
                        fresh--;
                    }
            }
        }

        if(fresh != 0) return -1;
        return time;
    }
}
