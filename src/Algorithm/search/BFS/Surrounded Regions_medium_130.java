
class Solution {
    public void solve(char[][] board) {
      for(int i = 0;i < board[0].length;i++){
          if(board[0][i] == 'X' || board[0][i] == '#'){
               continue;
          } else{
              dfs(board,0,i); 
          }            
      }
      for(int i = 0;i < board[0].length;i++){
          if(board[board.length - 1][i] == 'X' || board[board.length - 1][i] == '#'){
                continue;
          }else{
                dfs(board,board.length - 1,i);  
          }         
      }
      for(int j = 0;j < board.length;j++){
          if(board[j][0] == 'X' || board[j][0] == '#'){
              continue;
          }else{
              dfs(board,j,0); 
          }
                
      }
      for(int j = 0;j < board.length;j++){
          if(board[j][board[0].length - 1] == 'X' || board[j][board[0].length - 1] == '#'){
              continue;
          }else{
              dfs(board,j,board[0].length - 1);
          }
          
      }
       for(int i = 0;i < board.length;i++){
           for(int j = 0;j < board[i].length;j++){
               if(board[i][j] == '#'){
                   board[i][j] = 'O';
               }else if(board[i][j] == 'O'){
                   board[i][j] = 'X';
               }
           }
       }
      
    }
    public void dfs(char[][] board,int r,int c){
        if(!(r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[0].length - 1))
            return;
        if(board[r][c] == 'X')
            return;
        if(board[r][c] == '#')
            return;
        board[r][c] = '#';
        dfs(board,r - 1,c);
        dfs(board,r + 1,c);
        dfs(board,r,c - 1);
        dfs(board,r,c + 1);
    }
}