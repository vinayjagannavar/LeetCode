class Solution {
    int i=0;

    public String reverseParentheses(String s) {
        char[] str = s.toCharArray();
        
        return helper(str);
    }

    private String helper(char[] s){
        StringBuilder sb = new StringBuilder();

        while(i < s.length){
            if(s[i] == '('){
                i++;
                String st = helper(s);
                sb.append(st);
            }
            else if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }
            else{
                sb.append(s[i]);
                i++;
            }

        }
        
        return sb.toString();
    }
} 