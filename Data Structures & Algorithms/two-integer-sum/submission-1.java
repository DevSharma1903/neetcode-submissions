class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            index.put(nums[i], i);
        }

        for(int i =0; i<nums.length; i++){
            int temp = target - nums[i];
            if(index.containsKey(temp) && index.get(temp) != i){
                return new int[]{i, index.get(temp)};
            }
        }

        return new int[0];
    }

}
