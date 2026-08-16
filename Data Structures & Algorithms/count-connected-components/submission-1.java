class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int cnt = n;
        for(int[] i : edges){
            if(dsu.solve(i[0], i[1])){
                cnt--;
            }
        }

        return cnt;
    }
}

class DSU{
    List<Integer> par = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    public DSU(int n){
        for(int i=0; i<n; i++){
            par.add(i);
            rank.add(0);
        }
    }

    public int findUlt(int node){
        if(node == par.get(node)){
            return node;
        }

        int ult = findUlt(par.get(node));
        par.set(node, ult);
        return ult;
    }

    public boolean solve(int u, int v){
        int pu = findUlt(u);
        int pv = findUlt(v);

        if(pu == pv) return false;

        if(rank.get(pu) < rank.get(pv)){
            par.set(pu, pv);
        }else if(rank.get(pu) > rank.get(pv)){
            par.set(pv, pu);
        }
        else{
            par.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }

        return true;
    }
}
