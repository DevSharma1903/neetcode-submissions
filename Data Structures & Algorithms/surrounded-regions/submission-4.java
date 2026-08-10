class Solution {
    int[][] vis;
    public void solve(char[][] board) {
        vis = new int[board.length][board[0].length];
        int n = board.length;
        int m = board[0].length;

        for(int[] i : vis){
            Arrays.fill(i, 0);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i==0 || j==0 || i==board.length-1 || j==board[0].length-1
                ) && vis[i][j] == 0 && board[i][j] == 'O'){
                    bfs(i, j, board);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(int n, int m, char[][] board){
        vis[n][m] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, m});

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int k=0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length
                && vis[nr][nc] == 0 && board[nr][nc] == 'O'){
                    vis[nr][nc] = 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
