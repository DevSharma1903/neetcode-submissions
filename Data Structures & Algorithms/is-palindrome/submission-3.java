class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] cArr = s.toCharArray();
        char[] conv1 = new char[cArr.length];
        boolean flag = true;

        if(cArr.length == 1){
            return true;
        }

        int index = 0;
        for(int i =0; i<cArr.length; i++){
            char c = cArr[i];
            if ((c >= '0' && c <= '9') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z')) {
                conv1[index] = c;
                index++;
            }
        }

        char[] conv2 = new char[index];
        for(int i =0; i<index; i++){
            conv2[i] = conv1[i];
        }
        int j =conv2.length-1;

        for(int i=0; i<conv2.length; i++){
            if(conv2[i] != conv2[j]){
                flag = false;
                break;
            }
            j--;
        }

        return flag;
    }
}
