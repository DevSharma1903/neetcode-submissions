class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int n = prerequisites.length;
        for(int i=0; i<n; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] id = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it : adj.get(i)){
                id[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(id[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> top = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            top.add(node);

            for(int it : adj.get(node)){
                id[it]--;
                if(id[it] == 0){
                    q.offer(it);
                }
            }
        }

        if(top.size() == numCourses) return true;
        return false;
    }
}
