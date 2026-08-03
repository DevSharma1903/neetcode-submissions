class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int maxC = 0;
        

        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        for(int i = 0; i<s.length(); i++){
            if(!set.contains(s.charAt(i))){
                count++;
                set.add(s.charAt(i));
            }
            else{
                maxC = Math.max(count, maxC);
                i = i - count;
                count = 0;
                set.clear();
            }
        }

        maxC = Math.max(count, maxC);
        return maxC;
    }
}
