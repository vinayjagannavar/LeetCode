class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int minDays = 0;

        if((long)m*k > n){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int day: bloomDay){
            max = Math.max(max,day);
            min = Math.min(min,day);
        }

        while(min <= max){
            int mid = min + (max - min)/2;

            if(possible(bloomDay,mid,m,k)){
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean possible(int[] bloomDay,int day, int m, int k){
        int count = 0;
        int noOfbouquets = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                noOfbouquets += count/k;
                count = 0;
            }
        }
        noOfbouquets += count/k;

        if(noOfbouquets >= m){
            return true;
        }
        else{
            return false;
        }
    }
}