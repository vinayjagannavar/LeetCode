class Solution {

    public int findTheWinner(int n, int k) {
        return josephusHelper(n,k) + 1;
    }
    public int josephusHelper(int n,int k){
    if(n==1) return 0;
      return (josephusHelper(n-1,k)+k) % n;
    }

    // public int findTheWinner(int n, int k) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     int count = 0;

    //     for(int i=1; i<=n; i++){
    //         queue.offer(i);
    //     }

    //     while(queue.size() > 1){
    //         int num = queue.poll();
    //         count++;
    //         if(count != k){
    //             queue.offer(num);
    //         }
    //         if(count==k){
    //             count=0;
    //         }
    //     }

    //     return queue.poll();
    // }
}
