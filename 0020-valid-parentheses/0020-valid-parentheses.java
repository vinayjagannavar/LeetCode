class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' ||ch == '[' ){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char pop = st.pop();
                if(ch == ')' && pop != '('){
                    return false;
                }
                if(ch == ']' && pop != '['){
                    return false;
                }
                if(ch == '}' && pop != '{'){
                    return false;
                }
            }
        }
        return st.size()==0?true:false;
    }
}