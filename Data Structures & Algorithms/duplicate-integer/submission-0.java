class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean flag = false;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for(int value : freq.values()){
            if(value > 1){
                flag = true;
                break;
            }
        }

        return flag;
    }
}