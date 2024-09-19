class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        comb(1, n, k, result, new ArrayList());
        return result;
    }
    private void comb(int index, int n, int k, List<List<Integer>> result,List<Integer> tempList) {
        if(k==0){
            result.add(new ArrayList<>(tempList));
            return;
        }
         
        for(int i = index; i <= n; i++) {
          
            tempList.add(i);
            comb(i + 1, n, k-1, result,tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}