class Solution {
    int[] nums;
    List<List<Integer>> list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, cur);
        return list;
    }

    public void backtrack(int i, List<Integer> cur){
        if(i==nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }

        //with nums[i] gng
        cur.add(nums[i]);
        backtrack(i+1, cur);
        cur.remove(cur.size()-1);

        //without nums[i] gng
        while(i<nums.length-1 && nums[i] == nums[i+1]){
            i+=1;
        }

        backtrack(i+1, cur);
    }
}
