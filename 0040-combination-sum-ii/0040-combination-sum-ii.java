class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        comboPos(candidates, target, 0, output, new ArrayList<>());
        return output;
    }

    private void comboPos(int[] candidates, int target, int index, List<List<Integer>> output, List<Integer> inner){

        if(target == 0){
            output.add(new ArrayList<>(inner));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;

            if(candidates[i] > target){
                break;
            }

            inner.add(candidates[i]);

            comboPos(candidates, target - candidates[i], i+1, output, inner);

            inner.remove(inner.size() - 1);
        }
    }
}

