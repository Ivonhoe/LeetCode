class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        
        boolean[][] visited = new boolean[m][n]; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board, visited, words, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, char[] words, int i, int j, int k){
        if(i<0||i>=board.length||j<0||j>=board[0].length||k>=words.length||
          visited[i][j] ){
            return false;
        }
        if(board[i][j]!=words[k]){
            return false;
        }else if(k == words.length-1){
            return true;
        }
        visited[i][j] = true;
        if(dfs(board, visited, words, i+1,j,k+1)||
          dfs(board, visited, words, i-1, j, k+1)||
          dfs(board, visited, words, i, j+1, k+1)||
          dfs(board, visited, words, i, j-1, k+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}