class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int min = Integer.MAX_VALUE;
        boolean[] a = new boolean[1441];

        for (String time : timePoints) {
            String[] t = time.split(":");
            int hr = Integer.parseInt(t[0]);
            int mins = Integer.parseInt(t[1]);
            int timeInMin = 60 * hr + mins;
            if(a[timeInMin]){
                return 0; //00:00 repeats
            }
            a[timeInMin] = true;
        }

        int first = -1;
        int prev = -1;
        int curr = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i]) {
                if (curr == -1) {
                    first = i;
                    curr = i;
                } else {
                    prev = curr;
                    curr = i;
                    min = Math.min(min, curr - prev);
                }
            }
        }

        return Math.min(min, 1440 - curr + first);
    }
}