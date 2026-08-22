class Solution {
    int[] nums;
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, cur);
        return list;
    }

    public void backtrack(int i, List<Integer> cur){
        if(i == nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(i+1, cur);
        cur.remove(cur.size()-1);
        backtrack(i+1, cur);
    }
}
