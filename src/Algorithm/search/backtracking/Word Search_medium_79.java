//做法一，贼慢
class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder path = new StringBuilder();
        boolean [][] visited = new boolean[board.length][board[0].length];
        int depth = 0;
        List res = new ArrayList();
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                depth = 0;
                if(board[i][j] == word.charAt(depth)){
                    dfs(board,word,visited,i,j,depth + 1,path,res);
                }
                if(res.contains(word))
                    return true;
            }
        }
        return false;
    }
    public void dfs(char[][] board, String word,boolean [][] visited,int r,int c,int depth,StringBuilder path,List res){
        if(!(r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[r].length))
            return ;
        if(visited[r][c])
            return;
        if(res.contains(word))
            return;
        visited[r][c] = true;
        path.append(board[r][c]);
        if(path.toString().equals(word)){
            res.add(word);
            return;
        }

        if(r - 1 >= 0 && board[r - 1][c] == word.charAt(depth)){
            dfs(board,word,visited,r - 1,c,depth + 1,path,res);
        }
        if(r + 1 <= board.length - 1 && board[r + 1][c] == word.charAt(depth)){
            dfs(board,word,visited,r + 1,c,depth + 1,path,res);
        }
        if(c - 1 >= 0 && board[r][c - 1] == word.charAt(depth)){
            dfs(board,word,visited,r,c - 1,depth + 1,path,res);
        }
        if(c + 1 <= board[r].length - 1 && board[r][c + 1] == word.charAt(depth)){
            dfs(board,word,visited,r,c + 1,depth + 1,path,res);
        }
        visited[r][c] = false;
        path.deleteCharAt(path.length() - 1);
    }
}

//一下为c++写法，学习返回boolean的思路
class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[0].size(); j++){
                if(backtrack(board, word, 0, i , j)){ // 从二维表格的每一个格子出发
                    return true;
                }
            }
        }
        return false;
    }
private:
    bool backtrack(vector<vector<char>>& board, string& word, int wordIndex, int x, int y){
        if( board[x][y] != word[wordIndex]){ // 当前位的字母不相等，此路不通
            return false;
        }
        if(word.size() - 1  == wordIndex){ // 最后一个字母也相等, 返回成功
            return true;
        }
        char tmp = board[x][y]; 
        board[x][y] = 0; // 避免该位重复使用
        wordIndex++;
        if((x > 0 && backtrack(board, word, wordIndex, x - 1, y)) // 往上走 (此处多谢笑川兄指正)
        || (y > 0 && backtrack(board, word, wordIndex, x, y - 1)) // 往左走
        || (x < board.size() - 1 && backtrack(board, word, wordIndex, x + 1, y)) // 往下走
        || (y < board[0].size() - 1 && backtrack(board, word, wordIndex, x, y + 1))){ // 往右走
            return  true; // 其中一条能走通，就算成功
        }
        board[x][y] = tmp; // 如果都不通，则回溯上一状态
        return false;
    }
};
