class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int ans = dfs(0, 0, k, visited);
        return ans;
    }
    
    private int dfs(int i, int j, int k, boolean[][] visited){
        if(i<0||j<0||i>visited.length-1||j>visited[0].length-1||visited[i][j]){
            return 0;
        }
        int sum = number(i)+number(j);
        if(sum>k){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i,j+1,k,visited)+dfs(i,j-1,k,visited)+dfs(i+1,j,k,visited)+dfs(i-1,j,k,visited);
    }
    
    private int number(int num){
        int ans = 0;
        while(num>0){
            ans += num%10;
            num = num/10;
        }
        return ans;
    }
}