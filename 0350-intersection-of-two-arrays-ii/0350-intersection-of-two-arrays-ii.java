import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        for(int num: nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                resultList.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                } 
            }   
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = resultList.get(i);
        }

        return result;
    }
}
