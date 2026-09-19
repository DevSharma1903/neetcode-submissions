class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean flag = false;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) > 1){
                flag = true;
                break;
            }
        }
        return flag;
    }
}