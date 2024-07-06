class Solution {
    public int passThePillow(int n, int time) {
        int nextPerson = n-1;

        if(time < n){
            return time+1;
        }

        int q = time / nextPerson;
        int r = time % nextPerson;
        int result;

        if(q % 2 == 0){
            return r + 1;
        }
        else{
            return n - r;
        }

    }
}