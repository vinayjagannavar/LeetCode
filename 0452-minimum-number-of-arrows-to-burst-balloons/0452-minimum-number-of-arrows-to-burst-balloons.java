class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));  // Sort by end
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}

// [1,6] [2,8] [8-10] [7,12] [10,16] 

//[2,6] [10,10]