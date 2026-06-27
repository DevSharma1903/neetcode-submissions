class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        for(int i=0; i<heights.length-1; i++){
            for(int j=i+1; j<heights.length; j++){
                int area = 0;
                if(heights[i]<heights[j]){
                    area = heights[i] * (j-i);
                }
                else{
                    area = heights[j]*(j-i);
                }
                max = Math.max(max, area);
            }
        }

        return max;
    }
}
