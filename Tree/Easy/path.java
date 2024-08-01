import java.util.ArrayList;
import java.util.List;

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
    private List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if (root != null) {
            findPaths(root, "");
        }
        return ans;
    }

    private void findPaths(TreeNode node, String path) {
        if (node.left == null && node.right == null) { // If the current node is a leaf
            ans.add(path + node.val);
        }
        if (node.left != null) {
            findPaths(node.left, path + node.val + "->");
        }
        if (node.right != null) {
            findPaths(node.right, path + node.val + "->");
        }
    }
}
