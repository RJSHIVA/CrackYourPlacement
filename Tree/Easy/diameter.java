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
    int DAIEMETER = 0 ;
    int height = 0;
    public int diameterOfBinaryTree(TreeNode root) {
         maxDepth(root);
        return DAIEMETER;

    }

      private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        DAIEMETER = Math.max(DAIEMETER, left + right);
        height = Math.max(left, right) + 1;
        
        return DAIEMETER;
    }
}