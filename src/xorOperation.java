public class xorOperation {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];

        nums[0] = start;
        if(n == 1){
            return start;
        }
        for (int i = 1; i < n; i++) {
            nums[i] = nums[0] + 2 * i;
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
