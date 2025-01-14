class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        
        int[] c = new int[n];

        for(int i=0; i<n; i++){
            freq[A[i]]++;
            freq[B[i]]++;

            int count=0;
            for(int f: freq){
                if(f==2){
                    count++;
                }
            }

            c[i]=count;
        }

        return c;
    }
}