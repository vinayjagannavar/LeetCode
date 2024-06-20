class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);
        if(m==2){
            return position[n-1] - position[0];
        }

        int low = 0;
        int high = position[n-1] - position[0];

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(position, m, mid)){
                //high = mid - 1;
                low = mid + 1;
            }
            else{
                //low = mid + 1;
                high = mid - 1;
            }
        }

        return high;
        
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