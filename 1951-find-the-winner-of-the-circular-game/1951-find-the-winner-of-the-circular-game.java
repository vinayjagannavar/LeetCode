class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i=1; i<=n; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            int num = queue.poll();
            count++;
            if(count != k){
                queue.offer(num);
            }
            if(count==k){
                count=0;
            }
        }

        return queue.poll();
    }
}
