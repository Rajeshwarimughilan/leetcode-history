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
    public int minDepth(TreeNode root) {
        int res = compute(root);
        return res;
    }

    public int compute(TreeNode root){
        if(root == null) return 0;

        if(root.left == null){
            return compute(root.right) + 1;
        }

        if(root.right == null){
            return compute(root.left) + 1;
        }

        return Math.min(compute(root.left), compute(root.right)) + 1;
    }
}