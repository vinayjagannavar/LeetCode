class Solution {
    public boolean isSubsequence(String s, String t) {

        int index_s = 0;
        int index_t = 0;

        if(s.length()==0){
            return true;
        }

        while(index_s<s.length() && index_t<t.length()){
            if(s.charAt(index_s) == t.charAt(index_t)){
                index_s++;
            }
            index_t++;
        }

        return index_s == s.length();
    }
}