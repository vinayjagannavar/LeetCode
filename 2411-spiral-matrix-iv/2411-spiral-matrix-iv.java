/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] output = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(output[i], 2000);
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int dir = 0;
        int x = 0;
        int y = 0;


        while(head != null){

            output[x][y] = head.val;
            head = head.next;

            int newX = x + directions[dir][0];
            int newY = y + directions[dir][1];

            if (newX < 0 || newX >= m || newY < 0 || newY >= n || output[newX][newY] != 2000) {
                // Change direction clockwise (right -> down -> left -> up)
                dir = (dir + 1) % 4;
                newX = x + directions[dir][0];
                newY = y + directions[dir][1];
            }

            x = newX;
            y = newY;            
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (output[i][j] == 2000) {
                    output[i][j] = -1;
                }
            }
        }

        return output;
    }
}