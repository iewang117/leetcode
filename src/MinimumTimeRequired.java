public class MinimumTimeRequired {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        //有n种工作，则工作的分配情况有2^n种
        int[] sum = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            //numberOfTrailingZeros返回最低位的1之后0的个数
            //y为与i只有最后一位1差距的情况
            int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
            //该情况下的工作量，等于y的工作量加上最低位工作量
            sum[i] = sum[y] + jobs[x];
        }

        //给前i个人分配了工作，分配情况为j
        int[][] dp = new int[k][1 << n];
        for(int i = 0; i < (1 << n); i++){
            dp[0][i] = sum[i];
        }

        for (int i = 1; i < k; i++) {
            for(int j = 0; j < (1 << n); j++){
                int min = Integer.MAX_VALUE;
                //枚举所有j的子集
                for(int x = j; x != 0; x = (x - 1) & j){
                    //前i-1人要分配j-x的工作，比较最后一个人工作时间久还是前面的人工作时间久
                    min = Math.min(min, Math.max(dp[i-1][j-x], sum[x]));
                }
                dp[i][j] = min;
            }
        }

        return dp[k-1][(1 << n) -1];
    }
}
