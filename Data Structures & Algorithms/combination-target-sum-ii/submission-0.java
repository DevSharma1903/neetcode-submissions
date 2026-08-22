class Solution {
    int[] nums;
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.nums = candidates;
        list = new ArrayList<>();
        backtrack(0, target, new ArrayList<>(), 0);
        return list;
    }

    public void backtrack(int i, int target, List<Integer> cur, int sum){
        if(sum == target){
            list.add(new ArrayList<>(cur));
            return;
        }

        if(i == nums.length || sum > target){
            return;
        }

        cur.add(nums[i]);
        backtrack(i+1, target, cur, sum+nums[i]);
        cur.remove(cur.size()-1);

        while(i<nums.length-1 && nums[i] == nums[i+1]){
            i+=1;
        }

        backtrack(i+1, target, cur, sum);
    }
}