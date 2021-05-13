/**
 * 1269. 停在原地的方案数
 * 动态规划
 */
public class NumberStayInSamePlace {
    public int numberStayInSamePlace(int steps, int arrLen) {
        final int modNum = 1000000007;
        //dp[i][j]表示经历i步，位置在j的方法数
        //状态转移，可以从左右或现在的位置一步得到
        //不可能移动到比steps更远的地方，步数不够
        //即dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] + dp[i-1][j]
        int maxDist = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxDist + 1];
        //用0步到达0的方法只有一种
        dp[0][0] = 1;
        //用0步到达别的位置都不可能，为0，i从1开始迭代
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 0; j <= maxDist; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % modNum;
                }
                if (j + 1 <= maxDist) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % modNum;
                }
            }
        }
        return dp[steps][0];
    }
}
