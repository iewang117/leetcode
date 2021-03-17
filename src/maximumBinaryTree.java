public class maximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        public TreeNode build(int[] nums, int low, int high) {
            if (low > high) {
                return null;
            }

            int index = -1, max = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }

            TreeNode root = new TreeNode(max);

            root.left = build(nums, low, index - 1);
            root.right = build(nums, index + 1, high);

            return root;
        }
    }
}
