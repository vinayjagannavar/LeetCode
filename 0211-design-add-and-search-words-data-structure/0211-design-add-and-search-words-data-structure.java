class WordDictionary {
    private TrieNode root;

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()){
            TrieNode node = current.children[c - 'a'];
            if(node==null){
                node = new TrieNode();
                current.children[c-'a'] = node;
            }
            current = node;
        }

        current.endOfWord= true;
    }
    
    public boolean search(String word) {
        return helperSearch(word, 0, root);
    }    
    
    private boolean helperSearch(String word, int index, TrieNode current){
        if (index == word.length()) {
            return current.endOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
        
            for (TrieNode child : current.children) {
                if (child != null && helperSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        else {
            TrieNode node = current.children[c - 'a'];
            if (node == null) {
                return false;
            }
            return helperSearch(word, index + 1, node);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */