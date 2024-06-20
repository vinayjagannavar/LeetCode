class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);

        int low = 0;
        int high = position[n-1] - position[0];
        int result = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(position, m, mid)){
                result = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return result;
        
    }

    private boolean isPossible(int[] position, int m, int mid){
        int min = Integer.MAX_VALUE;
        int prev = position[0];
        for(int i=1; i<position.length; i++){
            if(position[i] - prev >= mid){
                m--;
                prev = position[i];
                if(m==1){
                    return true;
                }
            }

        }

        return false;
    }
}