class Solution {
    public int minBitFlips(int start, int goal) {
        int length = Math.max(Integer.toBinaryString(start).length(), Integer.toBinaryString(goal).length());
        int flip=0;
        while(length>0){
            int bitStart = start & 1;
            int bitGoal = goal & 1;

            if(bitGoal!=bitStart){
                flip+=1;
            }

            start >>=1;
            goal >>=1;
            length--;
        }

        return flip;
    }
}