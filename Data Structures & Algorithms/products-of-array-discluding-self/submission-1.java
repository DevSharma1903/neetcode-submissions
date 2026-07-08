class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int prod = 1;

        for(int i=0; i<prefix.length; i++){
            prod = prod * nums[i];
            prefix[i] = prod;
        }
        prod=1;
        for(int i=nums.length-1; i>=0; i--){
            prod = prod * nums[i];
            postfix[i] = prod;
        }

        for(int i=0; i<nums.length; i++){
            if(i == 0){
                nums[i] = 1 * postfix[i+1];
            }
            else if(i==nums.length-1){
                nums[i] = prefix[i-1] * 1;
            }
            else{
                nums[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return nums;
    }
}  
