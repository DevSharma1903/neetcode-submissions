class Solution {
    public int characterReplacement(String s, int k) {
        int maxF=0, maxLen=0, l=0, r=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            while((r-l+1)-maxF > k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }

            maxLen = Math.max(maxF, r-l+1);
            r++;
        }

        return maxLen;

    }
}
