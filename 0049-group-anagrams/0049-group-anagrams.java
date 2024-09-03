// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {

//         Map<String,List<String>> map = new HashMap();

//         if(strs.length == 0){
//             return new ArrayList<>();
//         }

//         for(String str: strs){
//             String freqString = getFrequencyString(str);
//             if(!map.containsKey(freqString)){
//                 List<String> list = new ArrayList<>();
//                 list.add(str);
//                 map.put(freqString,list);
//             }
//             else{
//                 map.get(freqString).add(str);
//             }
//         }

//         return new ArrayList<>(map.values());
//     }

//     private String getFrequencyString(String str){
//         int alpha[] = new int[26];

//         for(char c: str.toCharArray()){
//             alpha[c - 'a'] += 1;
//         }

//         char c = 'a';

//         StringBuilder sb = new StringBuilder();

//         for(int i=0; i<alpha.length; i++){
//             sb.append(c);
//             sb.append(alpha[i]);
//             c++;
//         }

//         return sb.toString();
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}