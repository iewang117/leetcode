import java.util.Arrays;

public class LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int ans = 0;
            //以nums[i]为尾的最长递增序列长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {

                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            for (int i = 0; i < dp.length; i++) {
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
}
