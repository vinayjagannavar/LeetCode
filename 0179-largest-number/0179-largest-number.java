class Solution {
    public String largestNumber(int[] nums) {
        String[] numString = new String[nums.length];

        for(int i=0; i<nums.length; i++){
            numString[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numString, (a,b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            sb.append(numString[i]);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}