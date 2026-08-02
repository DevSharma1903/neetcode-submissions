public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            max = Math.max(i, max);
        }

        int l = 1;
        int r = max;
        int mid = 0;
        while(l<=r){
            mid = l + (r-l)/2;
            int time = calcTime(mid, piles);
            if(time>h){
                l = mid+1;
            }else{
                r=mid-1;
            }
        }

        return l;
    }

    public int calcTime(int k, int[] piles){
        int sum = 0;
        for(int i : piles){
            sum += (int)Math.ceil((double)i / k);
        }

        return sum;
    }
}