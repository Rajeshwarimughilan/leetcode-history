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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        computesum(root, 0);
        return total;
    }

    public void computesum(TreeNode node, int curr){
        if(node == null) return;

        curr = curr * 10 + node.val; 

        if(node.left == null && node.right == null){
            total += curr;
            return;
        }

        computesum(node.left, curr);
        computesum(node.right, curr);
    }
}