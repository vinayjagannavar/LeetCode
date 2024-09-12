class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int count = 0;

        for(char ch: allowed.toCharArray()){
            set.add(ch);
        }

        for(String word : words){
            boolean valid = true;
            for(char ch: word.toCharArray()){
                if(!set.contains(ch)){
                    valid = false;
                    break;
                }
            }
            if(valid){
                count++;
            }
        }

        return count;
    }
}