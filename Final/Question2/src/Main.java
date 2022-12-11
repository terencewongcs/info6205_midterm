public class Main {
    public static void main(String[] args) {
        String[][] grid = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        System.out.println(getNumOfIslands(grid));
    }
    public static int getNumOfIslands(String[][] grid){
        int numOfIsland = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m; i ++){
            for(int j = 0 ; j < n; j ++){
                if( grid[i][j].equals("1") && visited[i][j] == false ){
                    numOfIsland++;
                    visit(grid, visited, i, j);
                }
            }
        }

        return numOfIsland;
    }

    private static void visit(String[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j].equals("0") || visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        visit(grid, visited, i -1, j);
        visit(grid, visited, i, j -1);
        visit(grid, visited, i, j + 1);
        visit(grid, visited, i + 1, j );
    }
}

//time complexity: O(n)
//space complexity: O(n)