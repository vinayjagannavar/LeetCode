class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1){
            if (!set.add(n)){
                return false;
            }

            int sum = 0;
            while (n > 0){
                int digit = n % 10;
                sum += digit * digit;

                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}