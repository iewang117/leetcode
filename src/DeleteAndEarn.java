public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        //考虑到存在相同元素，统计相同元素之和
        int maxVal = 0;
        for(int val : nums){
            maxVal = Math.max(val, maxVal);
        }
        int[] sum = new int[maxVal+1];
        for(int val : nums){
            sum[val] += val;
        }
        return rob(sum);
    }

    //打家劫舍
    public int rob(int[] nums){
        int length = nums.length;
        int dp[] = new int[length];
        //只有一个数
        if(length == 1){
            return dp[0];
        }
        if(length == 2){
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        //只有两个数
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[length - 1];
    }
}
