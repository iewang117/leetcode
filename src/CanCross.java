public class CanCross {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        //从j跳到i，跳了k步
        for (int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--){
                //k从1开始遍历
                int k = stones[i] - stones[j];

                //从j最多跳出j+1距离
                if(k > j + 1){
                    break;
                }

                dp[i][k] = dp[j][k-1] || dp[j][k+1] || dp[j][k];

                //跳到了
                if(i == n - 1 && dp[i][k]){
                    return true;
                }
            }


        }

        //跳不到
        return false;
    }
}
