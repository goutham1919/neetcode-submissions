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
    int re;
    public boolean isBalanced(TreeNode root) {
        re=0;
        return (dfs(root)!=-1)?true:false;
        
    }

    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left =dfs(root.left);
        if(left==-1) return -1;
        int right=dfs(root.right);
        if(right==-1) return -1;
        re=0;
        re=Math.abs(left-right);
        if(re>1) return -1;
        return 1+Math.max(left,right);
    }
}
