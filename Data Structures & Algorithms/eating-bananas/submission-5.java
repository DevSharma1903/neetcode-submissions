class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i =1;
        int maxV = 0;
        for(int k:piles){
            maxV = Math.max(maxV, k);
        }

        int j = maxV;
        int mid = 0;

        while(i<=j){
            mid = i + (j-i) / 2;
            int time = calcTime(mid, piles);
            if(time<=h){
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }

        return i;
    }

    public int calcTime(int mid, int[] p){
        int time = 0;
        for(int i =0; i<p.length; i++){
            time += (p[i] + mid -1)/mid;
        }

        return time;
    }
}
