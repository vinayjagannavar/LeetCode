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
// class Solution {
//     public int[][] spiralMatrix(int m, int n, ListNode head) {
//         int[][] output = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             Arrays.fill(output[i], -1);
//         }

//         int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

//         int dir = 0;
//         int x = 0;
//         int y = 0;


//         while(head != null){

//             output[x][y] = head.val;
//             head = head.next;

//             int newX = x + directions[dir][0];
//             int newY = y + directions[dir][1];

//             if (newX < 0 || newX >= m || newY < 0 || newY >= n || output[newX][newY] != -1) {
//                 // Change direction clockwise (right -> down -> left -> up)
//                 dir = (dir + 1) % 4;
//                 newX = x + directions[dir][0];
//                 newY = y + directions[dir][1];
//             }

//             x = newX;
//             y = newY;            
//         }

        

//         return output;
//     }
// }


class Solution {
    public int[][] spiralMatrix(int rows, int columns, ListNode head) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int [columns];
            Arrays.fill(matrix[i], -1);
        }

        int topRow = 0, bottomRow = rows - 1, leftColumn = 0, rightColumn = columns - 1;
        while (head != null) {
        
            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

        
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;

 
            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

       
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }

        return matrix;
    }
}