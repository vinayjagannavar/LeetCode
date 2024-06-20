class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length-1] - position[0];
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
        int count = 1;
        int prev = position[0];
        for(int i=1; i<position.length; i++){
            if(position[i] - prev >= mid){
                count++;
                prev = position[i];
                if(count==m){
                    return true;
                }
            }
        }

        return false;
    }
}