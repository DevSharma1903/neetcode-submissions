class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[temperatures.length];
        int index = 0;

        for(int i=0; i<temperatures.length; i++){
            int a = temperatures[i];
            while(!stack.isEmpty() && a>stack.peek()[0]){
                int[] p = stack.pop();
                arr[p[1]] = i-p[1];
            }
            stack.push(new int[]{a,i});
        }

        return arr;
    }
}
