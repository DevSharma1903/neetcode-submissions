class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();

        if(s_char.length != t_char.length){
            return false;
        }

        Arrays.sort(s_char);
        Arrays.sort(t_char);

        boolean flag = true;
        
        for(int i = 0; i<s_char.length; i++){
            if(s_char[i] != t_char[i]){
                flag = false;
                break;
            }
        }

        return flag;
    }
}
