class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int minDays = 0;

        if((long)m*k > n){
            return -1;
        }

        int min = 1;
        int max = Integer.MAX_VALUE;
        for(int day: bloomDay){
            max = Math.max(max,day);
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
                if(count==k){
                    count=0;
                    noOfbouquets++;
                    if(noOfbouquets==m){
                        return true;
                    }
                }
            }
            else{
                if((bloomDay.length-i)/k < m-noOfbouquets)
                    return false;
                count=0;
            }
        }

        return false;
    }
}