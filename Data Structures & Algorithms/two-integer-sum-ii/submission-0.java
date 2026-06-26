class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            map.put(numbers[i], i);
        }

        for(int i = 0; i<numbers.length; i++){
            int diff = target - numbers[i];
            if(map.containsKey(diff)){
                arr[1] = i+1;
                arr[0] = map.get(diff)+1;
            }
        }

        return arr;
    }
}
