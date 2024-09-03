class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1;
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
        }

        k--;

        while (k > 0) {
            int innerSum = 0;
            while (sum > 0) {
                innerSum += sum % 10;
                sum = sum / 10;
            }
            sum = innerSum;
            k--;
        }

        return sum;
    }
}
