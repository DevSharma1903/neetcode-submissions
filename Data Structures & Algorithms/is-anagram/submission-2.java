class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_c = s.toCharArray();
        char[] t_c = t.toCharArray();
        boolean flag = true;

        Arrays.sort(s_c);
        Arrays.sort(t_c);

        String s_s = new String(s_c);
        String t_s = new String(t_c);

        if(s_s.equals(t_s)){
            return true;
        }else{
            return false;
        }

    }
}
