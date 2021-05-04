import java.util.Arrays;

public class PaintHouse3 {
    //定义一个极大值，即粉刷的代价极高，一般最大值防止溢出
    static final int INFINITY = Integer.MAX_VALUE / 2;

    public int paintHouse3(int[] houses, int[][] cost, int m, int n, int target) {
        //dp[i][j][k]表示粉刷0到i的房子，最后一个房子粉刷颜色为j，属于第k个街区
        // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
        for (int i = 0; i < m; ++i) {
            houses[i]--;
        }

        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], INFINITY);
            }
        }

        /***
         * 状态转移分为两类，即house[i]=-1与否，最后一个房子有没有被粉刷
         * 1. houses[i] != -1，最后一个房子被粉刷过了:
         *      如果houses[i]不等于j，要粉刷一个被粉刷过的房子，代价等于INFINITY
         *      如果houses[i]等于j，这间不用粉刷了
         *          如果j等于前一间房子颜色j0，同个街区，dp[i][j][k]=dp[i-1][j][k]
         *          如果j不等于前一间房子颜色j0，不同街区，dp[i][j][k]=min{dp[i-1][j0][k-1]}
         * 2. houses[i] = -1，最后一个房子没被粉刷过:
         *      如果j等于前一间房子颜色j0，同个街区，dp[i][j][k]=dp[i-1][j][k]+cost[i][j][k]
         *      如果j不等于前一间房子颜色j0，不同街区，dp[i][j][k]=min{dp[i-1][j0][k-1]}+cost[i][j][k]
         *      即，加上了粉刷的代价
         */

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(houses[i] != -1 && houses[i] != j){
                    continue;
                }
                for(int k = 0; k < target; k++){
                    for(int j0 = 0; j0 < n ; j0++){
                        if(j == j0){
                            if(i == 0){
                                if(k == 0){
                                    dp[i][j][k] = 0;
                                }
                            } else{
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j][k]);
                            }
                        }else if(i > 0 && k > 0){
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j0][k-1]);
                        }
                    }

                    if (dp[i][j][k] != INFINITY && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }
                }
            }
        }

        int ans = INFINITY;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[m-1][j][target-1]);
        }

        return ans == INFINITY ? -1 : ans;
    }
}
