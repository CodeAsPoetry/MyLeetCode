/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        int height = 0;
        if(root==null){
            return height;
        }else{
            TreeNode temp = root;
            if(temp.left==null&&temp.right==null){
                height = 1;
            }else{
                height+=1;
                height+=Math.max(maxDepth(temp.left),maxDepth(temp.right));
            }
            return height;
        }
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        int height = 0;
        if(root==null){
            return height;
        }else{
            TreeNode temp = root;
            if(temp.left==null&&temp.right==null){    
                height=1;
            }else{
                height+=1;
                if(temp.left==null){
                    height+=minDepth(temp.right);
                }else{
                    if(temp.right==null){
                        height+=minDepth(temp.left);
                    }else{
                        height+=Math.min(minDepth(temp.right),minDepth(temp.left));
                    }
                }
                
            }
            return height;
        }
    }
}
