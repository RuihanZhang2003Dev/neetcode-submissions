class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area=dfs(grid,i,j,visited);
                    maxArea=Math.max(area,maxArea);
                }
            }
        }

        return maxArea;

    }

    public int dfs(int[][] grid, int r, int c, boolean[][] visited){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0 || visited[r][c]){
            return 0;
        }
        
        visited[r][c]=true;
        int res=1;

        res+=dfs(grid, r-1, c, visited)
        + dfs(grid, r+1, c, visited)
        + dfs(grid, r, c-1, visited)
        + dfs(grid, r, c+1, visited);

        //here we don't set visited to false 
        /*For island counting, once a piece of land is visited, it should stay visited so that other 
        calls don't process it again as a "new" island.*/

        return res;
    }
}
