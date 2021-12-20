class Trie {
    class TreeNode{
        private boolean isEnd;
        private TreeNode[] children;
        public TreeNode(){
            isEnd = false;
            children = new TreeNode[26];
        }
    }
    private TreeNode root;
    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode temp = root;
        for(int i = 0;i < word.length();i++){
            if(temp.children[word.charAt(i) - 'a'] == null){
                temp.children[word.charAt(i) - 'a'] = new TreeNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        TreeNode temp = root;
        for(int i = 0;i < word.length();i++){
            if(temp.children[word.charAt(i) - 'a'] == null){
                return false;
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode temp = root;
        for(int i = 0;i < prefix.length();i++){
            if(temp.children[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            temp = temp.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */