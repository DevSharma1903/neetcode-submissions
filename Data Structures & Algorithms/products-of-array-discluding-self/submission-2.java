class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int temp1 = 1;
        int temp2 = 1;

        for(int i=0; i<nums.length; i++){
            temp1 *= nums[i];
            pre[i] = temp1;
        }
        for(int i=nums.length-1; i>=0; i--){
            temp2 *= nums[i];
            post[i] = temp2;
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i == 0){
                ans[i] = 1 * post[i+1];
            }
            else if(i == nums.length-1){
                ans[i] = 1*pre[i-1];
            }
            else{
                ans[i] = pre[i-1] * post[i+1];
            }
        }

        return ans;
    }
}  
