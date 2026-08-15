class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] vis = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(adj, vis, i);
                cnt++;
            }
        }

        return cnt;
    }

    public void dfs(List<List<Integer>> adj, int[] vis, int node){
        vis[node] = 1;

        for(int i : adj.get(node)){
            if(vis[i] == 0){
                dfs(adj, vis, i);
            }
        }
    }
}
