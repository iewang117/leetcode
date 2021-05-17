import sun.reflect.generics.tree.Tree;

public class CousinsInBinaryTree {
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

    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound;

    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0 , null);
        return (xDepth == yDepth) && (xParent != yParent);
    }

    public void dfs(TreeNode node, int depth, TreeNode parent){
        if(node == null){
            return;
        }

        if(node.val == x){
            xParent = parent;
            xDepth = depth;
            xFound =true;
        }

        if(node.val == y){
            yParent = parent;
            yDepth = depth;
            yFound =true;
        }

        if(xFound && yFound){
            return;
        }

        dfs(node.left, depth + 1, node);

        if(xFound && yFound){
            return;
        }

        dfs(node.right, depth + 1, node);
    }
}
