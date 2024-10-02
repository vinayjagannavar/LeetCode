class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int ans[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            List<Integer> updateList = map.getOrDefault(arr[i], new ArrayList<>());
            updateList.add(i);
            map.put(arr[i], updateList);
            set.add(arr[i]);
        }

        int rank = 0;
        for(int num : set){
            rank += 1;
            List<Integer> getList = map.get(num);
            for(int val : getList){
                ans[val] = rank;
            }
        }

        return ans;
        
    }
}