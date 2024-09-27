// class MyCalendarTwo {

//     Map<Integer, Integer> calender;

//     public MyCalendarTwo() {
//         calender = new TreeMap<>();
//     }
    
//     public boolean book(int start, int end) {
//         int sum = 0;
//         calender.put(start, calender.getOrDefault(start, 0)+1);
//         calender.put(end, calender.getOrDefault(end, 0)-1);

//         for (int count : calender.values()) {
//             sum += count;

//             if(sum>2){
//                 calender.put(start, calender.getOrDefault(start, 0)-1);
//                 calender.put(end, calender.getOrDefault(end, 0)+1);

//                 if (calender.get(start) == 0) calender.remove(start);
//                 if (calender.get(end) == 0) calender.remove(end);

//                 return false;
//             }
//         }
//         return true;
        
//     }
// }


class MyCalendarTwo {

    List<int[]> calender;
    List<int[]> doubleBooking;

    public MyCalendarTwo() {
        calender = new ArrayList<>();
        doubleBooking = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] db : doubleBooking){
            if(db[0]<end && db[1]>start){
                return false;
            }
        }

        for(int[] e: calender){
            if(e[0]<end && e[1]>start){
                doubleBooking.add(new int[]{Math.max(e[0],start), Math.min(e[1],end)});
            }
        }

        calender.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */