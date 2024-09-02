class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Map<Character, Integer> map = new HashMap<>();

        // for(char c : magazine.toCharArray()){
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }

        // for(char c : ransomNote.toCharArray()){
        //     if(map.containsKey(c) && map.get(c)>0){
        //         map.put(c,map.get(c)-1);
        //     }
        //     else{
        //         return false;
        //     }
        // }

        // return true;

        int[] counter = new int[26];

        if(ransomNote.length() > magazine.length()){
            return false;
        }

        for(char c: magazine.toCharArray()){
            counter[c-'a'] += 1;
        }

        for(char ch: ransomNote.toCharArray()){
            if(counter[ch - 'a'] == 0){
                return false;
            }
            counter[ch - 'a'] -= 1;
        }

        return true;
    }
}