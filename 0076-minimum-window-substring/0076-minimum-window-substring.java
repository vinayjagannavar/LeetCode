class Solution {
    static{
        for(int i = 0; i < 500; i++) minWindow("", "a");
    }
    public static String minWindow(String s, String t) {
        int[] hash = new int[128];
        for(char c : t.toCharArray()) hash[c]++;
        int minI = -1, maxI = Integer.MAX_VALUE - 1;
        int count = 0, total = t.length();
        char[] sCh = s.toCharArray();
        for(int right = 0, left = 0; right < s.length(); right++){
            if(hash[sCh[right]]-- > 0) count++;
            if(count == total){
                while(true){
                    if(hash[sCh[left]] == 0){
                        hash[sCh[left]]++;
                        count--;
                        break;
                    } else {
                        hash[sCh[left]]++;
                        left++;
                    }
                }
                if(maxI - minI > right - left){
                    maxI = right;
                    minI = left;
                }
                left++;
            }
        }
        if(minI == -1) return "";
        return s.substring(minI,maxI + 1);
    }
}