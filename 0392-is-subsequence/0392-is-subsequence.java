// class Solution {
//     public boolean isSubsequence(String s, String t) {

//         int index_s = 0;
//         int index_t = 0;

//         if(s.length()==0){
//             return true;
//         }

//         while(index_s<s.length() && index_t<t.length()){
//             if(s.charAt(index_s) == t.charAt(index_t)){
//                 index_s++;
//             }
//             index_t++;
//         }

//         return index_s == s.length();
//     }   
// }

class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0,p2 = 0;
        char a1[] = s.toCharArray();
        char a2[] = t.toCharArray();
        int n1 = a1.length, n2 = a2.length;
        while(p1 < n1 && p2 < n2)
        {
            if(a1[p1] == a2[p2])
                p1++;
            p2++;
        }
        return p1 == n1;
    }
}