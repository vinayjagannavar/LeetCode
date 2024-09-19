class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backTracking(result, 1, n, k, new ArrayList<Integer>());

        return result;
    }

    private void backTracking(List<List<Integer>> result, int start, int n, int k, List<Integer> inner){
        if(inner.size() == k){
            result.add(new ArrayList<>(inner));
            return;
        }

        for(int i=start; i<=n; i++){
            inner.add(i);
            backTracking(result, i+1, n, k, inner);
            inner.remove(inner.size()-1);
        }
    }
}