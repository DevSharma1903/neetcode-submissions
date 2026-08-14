class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int maxV = 0;

        while(i<j){
            int vol = Math.min(heights[i], heights[j]) * (j-i);
            maxV = Math.max(maxV, vol);
            if(heights[i] < heights[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxV;
    }
}
