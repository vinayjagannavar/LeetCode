class Solution {
    public int lengthOfLongestSubstring(String s) {
       boolean visited[] = new boolean[256];
        int longest = 0;
        int left = 0;

        for(int i = 0; i<s.length(); i++){
            while(visited[s.charAt(i)]){
                visited[s.charAt(left)] = false;
                left++;
            }
            visited[s.charAt(i)]=true;
            longest = Math.max(longest,i-left+1);
        }

        return longest;

    }
}