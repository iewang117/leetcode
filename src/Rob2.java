public class Rob2 {
    public int rob2(int[] nums){
        int len = nums.length;
        if(len == 1){
            return nums[0];
        } else if(len == 2){
            return Math.max(nums[0],nums[1]);
        }

        return Math.max(dpRange(nums,0,len-2),dpRange(nums,1,len-1));
    }

    public int dpRange(int[] nums, int start, int end){
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for (int i = 2; i <= end-start; i++) {
            dp[i] = Math.max((dp[i-2]+nums[i+start]),dp[i-1]);
        }
        return dp[end-start];
    }
}
