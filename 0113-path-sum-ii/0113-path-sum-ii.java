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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        check(root, targetSum, 0, new ArrayList<>());
        return res;
    }

    public void check(TreeNode root, int targetsum, int sum, List<Integer> curr){
        if(root == null)
            return;

        sum += root.val;
        curr.add(root.val);

        if(root.left == null && root.right == null && sum == targetsum){
            res.add(new ArrayList(curr));
        }

        check(root.left, targetsum, sum, curr);
        check(root.right, targetsum, sum, curr);
        curr.remove(curr.size() - 1);
        return;

    }
}