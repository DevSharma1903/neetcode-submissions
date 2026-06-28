class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            String c = tokens[i];
            
            if(!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")){
                st.push(c);
            }
            else{
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());

                if(c.equals("+")){
                    st.push(Integer.toString(num1 + num2));
                }else if(c.equals("-")){
                    st.push(Integer.toString(num1 - num2));
                }else if(c.equals("*")){
                    st.push(Integer.toString(num1 * num2));
                }else if(c.equals("/")){
                    st.push(Integer.toString(num1 / num2));
                }
            }
        }

        return Integer.parseInt(st.pop());
    }
}
