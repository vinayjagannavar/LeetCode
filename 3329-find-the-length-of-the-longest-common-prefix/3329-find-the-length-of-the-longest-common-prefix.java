
class Solution {
    private final TrieNode root;

    class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap();
            endOfWord = false;
        }
    }

    public Solution() {
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            TrieNode node = current.children.get(c);

            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }

            current = node;
        }

        current.endOfWord = true;
    }

    public int search(String word){
        int count = 0;
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children.get(c) !=null){
                count++;
                current = current.children.get(c);
            }
            else{
                return count;
            }
        }
        return count;  
    }


    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestLength = 0;
        for(int num: arr1){
            insert(String.valueOf(num));
        }

        for(int num: arr2){
            longestLength = Math.max(longestLength, search(String.valueOf(num)));
        }

        return longestLength;
    }
}