class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (let1, let2) -> {
            String[] word1 = let1.split(" ",2);
            String[] word2 = let2.split(" ",2);

            boolean digit1 = Character.isDigit(word1[1].charAt(0));
            boolean digit2 = Character.isDigit(word2[1].charAt(0));

            if(!digit1 && !digit2){
                int compare = word1[1].compareTo(word2[1]);

                if(compare==0) return word1[0].compareTo(word2[0]);
                else return compare;
            }
            else if(digit1 && digit2){
                return 0;
            }
            else if(digit1 && !digit2){
                return 1;
            }
            else{
                return -1;
            }
        });

        return logs;
    }
}