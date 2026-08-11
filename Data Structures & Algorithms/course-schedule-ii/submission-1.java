class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] emp = new int[0];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for(int i=0; i<n; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] ind = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it : adj.get(i)){
                ind[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(ind[i] == 0) q.offer(i);
        }

        List<Integer> top = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            top.add(node);

            for(int it : adj.get(node)){
                ind[it]--;
                if(ind[it] == 0) q.offer(it);
            }
        }

        if(top.size() != numCourses)
            return new int[0];

        int[] ans = new int[top.size()];
        int index = 0;
        for(int i : top){
            ans[index] = i;
            index++;
        }

        return ans;

    }
}
