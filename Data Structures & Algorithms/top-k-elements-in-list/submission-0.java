class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[k];

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        for(int i=0; i<k; i++){
            arr[i] = pq.poll().getKey();
        }

        return arr;
    }
}
