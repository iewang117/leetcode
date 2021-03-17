public class flattenTreeToLinkedList {
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
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = null;
            root.right = left;

            TreeNode rightEnd = root;
            while (rightEnd.right != null) {
                rightEnd = rightEnd.right;
            }
            rightEnd.right = right;
        }
    }
}
