class Solution {
    public int maxArea(int[] heights) {
        int j = heights.length-1;
        int i=0;
        int max = 0;
        while(i<j){
            int area = 0;
        
            if(heights[i] < heights[j]){
                area = heights[i] * (j-i);
                i++;
            }else{
                area = heights[j] * (j-i);
                j--;
            }
            max = Math.max(max, area);
        }

        return max;
    }
}
