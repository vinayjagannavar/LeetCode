class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<expression.length(); i++){
            char curr = expression.charAt(i);

            if(curr == '*' || curr == '+' || curr == '-'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));

                List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                for(int x : left){
                    for(int y : right){
                        if(curr == '*'){
                            result.add(x*y);
                        }
                        else if(curr == '-'){
                            result.add(x-y);
                        }
                        else if(curr == '+'){
                            result.add(x+y);
                        }
                    }
                }
            }
        }

        if(result.size()==0){
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}