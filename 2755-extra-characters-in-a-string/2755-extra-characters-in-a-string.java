//TrieNode
class TrieNode {
    TrieNode[] childs;
    boolean isLast;
    TrieNode() {
        this.childs = new TrieNode[26];
        this.isLast = false;
    }
}
class Solution {
    TrieNode root;

    //Method to insert into the Trie Tree
    private void insert(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            int idx = c-'a';
            if(temp.childs[idx] == null) {
                temp.childs[idx] = new TrieNode();
            }
            temp = temp.childs[idx];
        }
        temp.isLast = true;
    }

    //Recursive method to solve.
    private int solve(int i, String s, Integer[] dp) {
        if(i == s.length()) {
            return 0;
        }

        //Using the caching for solving overlapping sub problems
        if(dp[i] != null) {
            return dp[i];
        }

        //Trying out possibility for the current word to delete.
        int minAns = solve(i+1, s, dp)+1;
        TrieNode temp = root;
        int j = i;

        //Trying to fing the word available in dictionary
        while(j < s.length()) {
            int idx = s.charAt(j)-'a';
            temp = temp.childs[idx];

            //If no word found then breaking
            if(temp == null) {
                break;
            }

            //If found a word then recursively solveing problem for remaining word
            if(temp.isLast) {
                minAns = Math.min(minAns, solve(j+1, s, dp));
            }
            j++;
        }

        //Caching and returning the minimum deletion
        return dp[i] = minAns;
    }
    public int minExtraChar(String s, String[] dictionary) {
        //root of the Trie Tree
        root = new TrieNode();

        //Creating a Trie Tree using dictionary words
        for(String word : dictionary) {
            insert(word);
        }

        //Recursive method to solve using dynamic programming
        return solve(0, s, new Integer[s.length()]);
    }
}