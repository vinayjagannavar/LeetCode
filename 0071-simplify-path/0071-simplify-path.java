class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");

        Stack<String> stack = new Stack<>();

        for(int i=0; i<parts.length; i++){
            if(parts[i].equals("") | parts[i].equals(".")) continue;

            if(parts[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(parts[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        // while(!stack.isEmpty()){
        //     sb.append("/").append(stack.pop());
        // }
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0? "/" : sb.toString();
    }
}