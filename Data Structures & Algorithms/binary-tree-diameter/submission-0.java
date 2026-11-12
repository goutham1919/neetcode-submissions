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
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result=0;
        dfs(root);

        return result;
    }

    public int dfs(TreeNode root){
        if(root==null) return -1;

        int left = dfs(root.left);
        int ryt= dfs(root.right);

        result=Math.max(result,left+ryt+2);

        return 1+Math.max(left,ryt);
    }
}
