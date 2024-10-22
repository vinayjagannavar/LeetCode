class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int[] p_arr = new int[26];
        int[] s_arr = new int[26];
        List<Integer> list = new ArrayList<>();

        for(char c : p.toCharArray()){
            p_arr[c - 'a']++;
        }

        for(int i=0; i<s.length();i++){
            if(i<k){
                s_arr[s.charAt(i)-'a']++;
            }
            else{
                s_arr[s.charAt(i-k)-'a']--;
                s_arr[s.charAt(i)-'a']++;
            }

            if(Arrays.equals(s_arr, p_arr)){
                list.add(i-k+1);
            }

        }

        return list;

    }
}