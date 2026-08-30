class Solution {
    int[] nums;
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(cur, 0);
        return list;
    }

    public void backtrack(List<Integer> cur, int i){
        if(i == nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(cur, i+1);
        cur.remove(cur.size()-1);
        backtrack(cur, i+1);
    }
}
