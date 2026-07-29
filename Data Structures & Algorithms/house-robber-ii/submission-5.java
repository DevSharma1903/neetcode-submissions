class Solution {
    public int[] dp1;
    public int[] dp2;

    public int rob(int[] nums) {
        dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        if(nums.length == 1 && nums[0] == 0) return 0;
        if(nums.length <= 1) return nums[0];
        
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];

        for(int i=0; i<nums.length-1; i++){
            arr1[i] = nums[i];
        }
        int index = 0;
        for(int i=1; i<nums.length; i++){
            arr2[index] = nums[i];
            index++;
        }

        return Math.max(test1(arr1, 0), test2(arr2, 0));
    }

    public int test1(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(dp1[i] != -1) return dp1[i];

        return dp1[i] = Math.max(test1(nums, i+1), nums[i]+test1(nums, i+2));

    }

    public int test2(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(dp2[i] != -1) return dp2[i];

        return dp2[i] = Math.max(test2(nums, i+1), nums[i]+test2(nums, i+2));

    }
}
