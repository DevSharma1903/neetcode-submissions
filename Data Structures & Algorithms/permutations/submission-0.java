class Solution {
    int[] nums;
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        list = new ArrayList<>();
        backtrack(new ArrayList<>());
        return list;
    }

    public void backtrack(List<Integer> cur){
        if(cur.size() == nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }

        for(int i : nums){
            if(cur.contains(i)) continue;

            cur.add(i);
            backtrack(cur);
            cur.remove(cur.size()-1);
        }
    }
}