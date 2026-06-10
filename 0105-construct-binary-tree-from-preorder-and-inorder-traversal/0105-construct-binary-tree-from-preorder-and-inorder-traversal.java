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
    int preidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode root = construct(preorder, inorder, 0, preorder.length - 1);
        return root;
    }

    public TreeNode construct(int[] po, int[] io, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(po[preidx++]);
        int idx = start;
        while(idx <= end && io[idx] != root.val){
            idx++;
        }

        root.left = construct(po, io, start, idx - 1);
        root.right = construct(po, io, idx + 1, end);

        return root;


    }
}