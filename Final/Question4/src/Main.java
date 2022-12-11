public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
        };
        System.out.println(getNumOfPaths(matrix));
    }

    private static int getNumOfPaths(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=Integer.MIN_VALUE;
                }
                else{
                    dp[i][j]=obstacleGrid[i][j];
                }
            }
        }


        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if (dp[i][0] == 1) {
                continue;
            }
            dp[i][0] = dp[i-1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
        }
        for (int i = 1; i < n; i++) {
            if (dp[0][i] == 1) {
                continue;
            }
            dp[0][i] = dp[0][i-1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(dp[i][j] == Integer.MIN_VALUE){
                    continue;
                }
                if(dp[i-1][j] == Integer.MIN_VALUE){
                    dp[i][j] = dp[i][j-1];
                }
                else if (dp[i][j-1] == Integer.MIN_VALUE){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }

}

//time complexity : O(n)
//space complexity : O(n)