class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int temp = 1;
        for(int i =0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i!=j){
                    temp *= nums[j];
                }
            }
            output[i] = temp;
            temp = 1;
        }

        return output;
    }
}  
