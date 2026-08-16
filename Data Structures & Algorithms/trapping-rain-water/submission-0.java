class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int[] minArr = new int[height.length];
        int maxLeft = 0;
        int maxRight = 0;

        for(int i=1; i<height.length; i++){
            maxLeft = Math.max(maxLeft, height[i-1]);
            leftMax[i] = maxLeft;
        }

        for(int i=height.length-2; i>=0; i--){
            maxRight = Math.max(maxRight, height[i+1]);
            rightMax[i] = maxRight;
        }

        for(int i=0; i<height.length; i++){
            minArr[i] = Math.min(leftMax[i], rightMax[i]);
        }

        int cnt = 0;
        for(int i=0; i<height.length; i++){
            cnt += Math.max((minArr[i] - height[i]), 0);
        }

        return cnt;

    }
}
