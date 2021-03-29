import java.util.ArrayList;

public class BinarySearchTreeIterator {

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

    class BSTIterator {

        private int index;
        private ArrayList<Integer> arr;


        public BSTIterator(TreeNode root) {
            index = 0;
            arr = new ArrayList<Integer>();
            traversal(root, arr);
        }

        public int next() {
            return arr.get(index++);
        }

        public boolean hasNext() {
            return index < arr.size();
        }

        private void traversal(TreeNode root, ArrayList<Integer> arr) {
            if (root == null) {
                return;
            }
            traversal(root.left, arr);
            arr.add(root.val);
            traversal(root.right, arr);
        }
    }

}
