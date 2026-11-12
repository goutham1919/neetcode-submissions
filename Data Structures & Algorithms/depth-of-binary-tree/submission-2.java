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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level =0;
        while(!deque.isEmpty()){
            int l =deque.size();
            for(int i=0;i<l;i++){
                TreeNode node = deque.pollFirst();
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
            }
            level+=1;
        }
        return level;
    }
}
