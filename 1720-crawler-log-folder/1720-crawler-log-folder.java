class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String log : logs){
            if(log.equals("../")){
                if(stack.size() == 0){
                    continue;
                }
                stack.pop();
            }
            else if(log.equals("./")){
                continue;
            }
            else{
                stack.push(log);
            }
            
        }

        return (stack.size() == 0)? 0: stack.size();
    }
}