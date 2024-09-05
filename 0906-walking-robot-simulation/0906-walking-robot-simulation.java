class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();

        for(int[] obs : obstacles){
            set.add(obs[0] + "," + obs[1]);
        }

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int x=0, y=0, direction=0, maxDistance=0;

        for(int com : commands){
            if(com == -1){
                direction = (direction+1) % 4;
            }
            else if(com == -2){
                direction = (direction+3) % 4;
            }
            else{
                for (int i=0; i<com; i++){
                    int newX = x + dir[direction][0];
                    int newY = y + dir[direction][1];

                    if(!set.contains(newX + "," + newY)){
                        x = newX;
                        y = newY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return maxDistance;
    }
}