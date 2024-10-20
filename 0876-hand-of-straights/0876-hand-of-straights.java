class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int card : hand){
            if(!map.containsKey(card)){
                map.put(card,1);
            }
            else{
                map.replace(card,map.get(card)+1);
            }
        }

        while(!map.isEmpty()){
            int min_val = map.firstKey();
            for(int card=min_val; card<min_val+groupSize; card++){
                if(!map.containsKey(card)){
                    return false;
                }
                int count = map.get(card);

                if(count>1){
                    map.replace(card,count-1);
                }
                else{
                    map.remove(card);
                }
            }
        }

        return true;

    }
}