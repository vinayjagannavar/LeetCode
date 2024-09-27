class MyCalendarTwo {

    Map<Integer, Integer> calender;

    public MyCalendarTwo() {
        calender = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        int sum = 0;
        calender.put(start, calender.getOrDefault(start, 0)+1);
        calender.put(end, calender.getOrDefault(end, 0)-1);

        for (int count : calender.values()) {
            sum += count;

            if(sum>2){
                calender.put(start, calender.getOrDefault(start, 0)-1);
                calender.put(end, calender.getOrDefault(end, 0)+1);

                if (calender.get(start) == 0) calender.remove(start);
                if (calender.get(end) == 0) calender.remove(end);

                return false;
            }
        }


        return true;
        

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */