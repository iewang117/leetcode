import java.util.Stack;

public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < leftMin[i - 1]) {
                leftMin[i] = nums[i - 1];
            } else {
                leftMin[i] = leftMin[i - 1];
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            int mid = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                mid = stack.pop();
            }
            if (leftMin[i] < mid) {
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
