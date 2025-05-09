class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split("\\s+");

        Map<Character, String> map = new HashMap<>();

        if(pattern.length() != words.length) {
            return false;
        }
        
        // Iterate through each character of the strings
        for(int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))){
                if(!map.containsValue(words[i])){
                    map.put(pattern.charAt(i),words[i]);
                }
                else{
                    return false;
                }
            }
            else{
                if(!map.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }
        }

        return true;
        
    }
}