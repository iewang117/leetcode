public class MinDiffInBST {
    int ans;
    int pre;

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

    public int minDiffInBST(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;

        midTraversal(root);

        return ans;
    }

    public void midTraversal(TreeNode root){
        if(root == null){
            return;
        }

        midTraversal(root.left);

        if(pre == -1){
            pre = root.val;
        }else{
            ans = Math.min((root.val-pre),ans);
            pre = root.val;
        }

        midTraversal(root.right);
    }
}
