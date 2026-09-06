class Solution {
    int[][] vis;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new int[n][m];
        for(int[] i : vis){
            Arrays.fill(i, -1);
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == -1 && grid[i][j] == '1'){
                    bfs(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void bfs(int n, int m, char[][] grid){
        vis[n][m] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n,m});

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];

            for(int k=0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length
                    &&vis[nr][nc]==-1&&grid[nr][nc]=='1'){
                        vis[nr][nc] = 1;
                        q.offer(new int[]{nr,nc});
                    }
            }
        }
    }
}
