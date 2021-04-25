import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
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

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);

        //根据中序遍历得到的list重新生成树
        TreeNode headNode = new TreeNode(-1);
        TreeNode curNode = headNode;
        for(int val : res){
            curNode.right = new TreeNode(val);
            curNode = curNode.right;
        }

        return headNode.right;
    }

    public void traversal(TreeNode node, List<Integer> res){
        if(node ==null){
            return;
        }

        traversal(node.left, res);

        res.add(node.val);

        traversal(node.right, res);
    }
}
