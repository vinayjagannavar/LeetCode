class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        int len = 0;

        int l = 0;
        int r = 0;

        while(r<nums.length){
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[r]){
                maxQueue.pollLast();
            }
            maxQueue.addLast(r);

            while(!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[r]){
                minQueue.pollLast();
            }
            minQueue.addLast(r);

            while(nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit){
                l++;

                while(maxQueue.peekFirst() < l){
                    maxQueue.pollFirst();
                }

                while(minQueue.peekFirst() < l){
                    minQueue.pollFirst();
                }
            }

            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }
}