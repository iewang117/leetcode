public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < 30; i++) {
            int d = 0;
            for (int j = 0; j < n; j++) {
                int val = nums[j];
                d += (val >> i) & 1;
            }
            ans += d * (n - d);
        }
        return ans;
    }
}
