class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i =0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int a = nums[i];
            if(a>0){
                break;
            }
            int j = i+1;
            int k = nums.length-1;

            while(j<k){
                int temp = a + nums[j] + nums[k];
                if(temp > 0){
                    k--;
                }else if(temp < 0){
                    j++;
                }
                else{
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return list;
    }
}
