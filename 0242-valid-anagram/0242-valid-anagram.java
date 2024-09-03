class Solution {
    public boolean isAnagram(String s, String t) {
        int alphabhets[] = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(char c: s.toCharArray()){
            alphabhets[c-'a'] += 1;
        }

        for(char ch: t.toCharArray()){
            if(alphabhets[ch-'a'] > 0){
                alphabhets[ch-'a'] -= 1;
            }
            else{
                return false;
            }
        }

        return true;
    }
}