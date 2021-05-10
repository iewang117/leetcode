import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<Integer>();
        dfs(root1, res1);
        List<Integer> res2 = new ArrayList<Integer>();
        dfs(root2, res2);

        return res1.equals(res2);
    }

    public void dfs(TreeNode node, List<Integer> res){
        if(node.left == null && node.right == null){
            res.add(node.val);
        }else{
            if(node.left != null){
                dfs(node.left, res);
            }
            if(node.right != null){
                dfs(node.right, res);
            }
        }
    }
}
