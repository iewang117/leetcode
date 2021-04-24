import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        //动态规划
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            //最大自子集的个数，最大子集中的最大整数
            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        //得到最大子集中的各个数
        List<Integer> res = new ArrayList<Integer>();
        if(maxSize == 1){
            res.add(nums[0]);
            return res;
        }

        //倒推更优
        for (int i = n-1; i >= 0 && maxSize > 0; i--) {
            if(dp[i] == maxSize && maxVal % nums[i] == 0){
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }
}
