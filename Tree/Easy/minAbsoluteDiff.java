// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right; 
//  *     }
//  * }
//  */
// class Solution {
//     private void inorderTraversal(TreeNode root, List<Integer> values) {
//         if (root == null) return;
//         inorderTraversal(root.left, values);
//         values.add(root.val);
//         inorderTraversal(root.right, values);
//     }
    
//     public int getMinimumDifference(TreeNode root) {
//         List<Integer> values = new ArrayList<>();
//         inorderTraversal(root, values);
        
//         int minDifference = Integer.MAX_VALUE;
//         for (int i = 1; i < values.size(); i++) {
//             int diff = values.get(i) - values.get(i - 1);
//             if (diff < minDifference) {
//                 minDifference = diff;
//             }
//         }
        
//         return minDifference;
//     }
// }

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
    TreeNode prev = null;
    int ans = Integer.MAX_VALUE;
    private void inorder(TreeNode root){
        if(root == null)
            return ;
        inorder(root.left);
        if(prev != null)
            ans = Math.min(ans, root.val - prev.val);
        prev = root;
        inorder(root.right);
        return ;
            
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }
}
