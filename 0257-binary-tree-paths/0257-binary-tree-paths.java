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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        build(root, new StringBuilder(), res);
        return res;
    }

    public void build(TreeNode node, StringBuilder sb, List<String> res){
        if(node == null) return;
        int len = sb.length();
        sb.append("->").append(node.val);
        if(node.left == null && node.right == null){
            res.add(sb.substring(2));
        }
        
        if(node.left != null) build(node.left, sb, res);
        if(node.right != null) build(node.right, sb, res);
        sb.setLength(len);
    }
}