class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        for(int[] i : vis){
            Arrays.fill(i, -1);
        }

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = 1;
                }
            }
        }

        int time = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            for(int k=0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length){
                    if(vis[nr][nc] == -1 && grid[nr][nc] == 1){
                        vis[nr][nc] = 1;
                        q.offer(new int[]{nr,nc,t+1});
                        fresh--;
                    }
                }
            }

            time = Math.max(time, t);
        }

        if(fresh != 0) return -1;

        return time;
    }
}
