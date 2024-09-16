class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] timeInMinutes = new int[timePoints.size()];
        for(int i=0; i<timePoints.size(); i++){
            int hoursToMin = Integer.parseInt(timePoints.get(i).substring(0,2))*60 + Integer.parseInt(timePoints.get(i).substring(3,5));
            timeInMinutes[i] = hoursToMin;
        }

        Arrays.sort(timeInMinutes);

        int minDiff = Integer.MAX_VALUE;

        for(int i=1; i<timeInMinutes.length; i++){
            if(timeInMinutes[i] - timeInMinutes[i-1] == 0){
                return 0;
            }

            minDiff= Math.min(minDiff, timeInMinutes[i] - timeInMinutes[i-1]);
        }

        int firstLastDiff = 1440 - timeInMinutes[timeInMinutes.length - 1] + timeInMinutes[0];
        minDiff = Math.min(minDiff, firstLastDiff);
        return minDiff;
    }
}