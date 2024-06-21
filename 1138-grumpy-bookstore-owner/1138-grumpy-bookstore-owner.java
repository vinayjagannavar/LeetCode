class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int nonGrumpySum = 0;
        int maxCustomers = 0;

        for(int i=0; i<n; i++){
            if(grumpy[i]==0){
                nonGrumpySum += customers[i];
            }
        }

        int count = 0;
        int window = 0;

        for(int i=0; i<minutes; i++){
            if(grumpy[i]==1){
                window += customers[i];
            }
            count++;
        }

        maxCustomers = nonGrumpySum + window;

        for(int i=minutes; i<n; i++){

            if(count==minutes){
                maxCustomers = Math.max(maxCustomers,nonGrumpySum + window);
                count--;
                if(i - minutes >= 0){
                    if(grumpy[i - minutes] == 1){
                        window -= customers[i - minutes];
                    }
                }
            }

            if(grumpy[i]==1){
                window += customers[i];
            }

            count++;

        }

        maxCustomers = Math.max(maxCustomers,nonGrumpySum + window);

        return maxCustomers;
    }
}