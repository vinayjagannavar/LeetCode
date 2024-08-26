class Solution {
    public boolean isPalindrome(String s) {

        String cleanedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(cleanedStr);

        int i=0;
        int j=sb.length()-1;

        while(i<=j){
            if(sb.charAt(i) == sb.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}