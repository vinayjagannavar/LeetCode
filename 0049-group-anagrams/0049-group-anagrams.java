class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedChar = new String(chars);
            if(!map.containsKey(sortedChar)){
                map.put(sortedChar,new ArrayList<>());
            }
            map.get(sortedChar).add(str);
        }

        return new ArrayList<>(map.values());

    }
}