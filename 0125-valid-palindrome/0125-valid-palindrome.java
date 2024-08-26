class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(j>i){
            char f=s.charAt(i);
            char l=s.charAt(j);
            if(!((f>='A' && f<='Z') || (f>='a' && f<='z') || (f>='0' && f<='9'))){
                i++;
                continue;
            }
            if(!((l>='A' && l<='Z') || (l>='a' && l<='z') || (l>='0' && l<='9'))){
                j--;
                continue;
            }
            if(f>='A' && f<='Z'){
                f=(char) (f-'A'+'a');
            }
            if(l>='A' && l<='Z'){
                l=(char) (l-'A'+'a');
            }
            if(f!=l) return false;
            i++;
            j--;
        }
        return true;
    }
}