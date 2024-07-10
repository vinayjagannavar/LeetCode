class Solution {
    public int minOperations(String[] logs) {

        int level = 0;

        for(String log : logs){
            if(log.equals("../")){
                if(level == 0){
                    continue;
                }
                level--;
            }
            else if(log.equals("./")){
                continue;
            }
            else{
                level++;
            }
        }

        return level;

        // Stack<String> stack = new Stack<>();
        // for(String log : logs){
        //     if(log.equals("../")){
        //         if(stack.size() == 0){
        //             continue;
        //         }
        //         stack.pop();
        //     }
        //     else if(log.equals("./")){
        //         continue;
        //     }
        //     else{
        //         stack.push(log);
        //     }
            
        // }

        // return (stack.size() == 0)? 0: stack.size();
    }
}