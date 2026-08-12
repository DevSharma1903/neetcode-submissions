class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges){
            int r = i[0];
            int c = i[1];

            adj.get(r).add(c);
            adj.get(c).add(r);
        }

        int[] vis = new int[n];

        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                if(dfs(i, -1, vis, adj) == true) return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int parent, int[] vis, List<List<Integer>> adj){
        vis[node] = 1;
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i, node, vis, adj) == true) return true;
            }else if(i!=parent){
                return true;
            }
        }

        return false;
    }
}
