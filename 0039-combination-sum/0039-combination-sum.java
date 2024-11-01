class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        comboPos(candidates, target, 0, 0, output, new ArrayList<>());
        return output;
    }

    private void comboPos(int[] candidates, int target, int i, int sum, List<List<Integer>> output, List<Integer> inner){
        if(sum==target){
            output.add(new ArrayList<>(inner));
            return;
        }

        if(sum>target || i>=candidates.length){
            return;
        }


        inner.add(candidates[i]);
        comboPos(candidates, target, i, sum + candidates[i], output, inner);
        inner.remove(inner.size() - 1);
        comboPos(candidates, target, i + 1, sum, output, inner);

    }
}