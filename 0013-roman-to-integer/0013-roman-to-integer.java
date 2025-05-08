class Solution {
    public int romanToInt(String s) {
        int result = 0, current = 0;

        for(int i=s.length()-1; i>=0; i--){
            switch(s.charAt(i)){
                case 'I': current = 1; break;
                case 'V': current = 5; break;
                case 'X': current = 10; break;
                case 'L': current = 50; break;
                case 'C': current = 100; break;
                case 'D': current = 500; break;
                case 'M': current = 1000; break;
            }
                if(4*current < result){
                    result -= current;
                }
                else{
                    result += current;
                }
        }
        return result;
    }
}