/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return build(1, n);
    }

    public List<TreeNode> build(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int root = start; root <= end; root++){
            List<TreeNode> left = build(start, root-1);
            List<TreeNode> right = build(root+1, end);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode rootnode = new TreeNode(root);
                    rootnode.left = l;
                    rootnode.right = r;
                    
                    res.add(rootnode);
                }
            }
            
        }

        return res;
    }
}