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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<ArrayList> stack = new Stack<ArrayList>(); 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        /**
        * 记录每一层的节点数，解决一个减一个
        * 当记录数为0，开辟新链表，把队列元素的数目赋给记录，下一层待解决的记录数
        * 当记录数不为0，原有链表添加即可
        *
        **/
        
        if(root!=null){
            
            TreeNode temp = root;   
            queue.offer(temp);              
            TreeNode current = null;
            int k=0;
            
            while(!queue.isEmpty()){   //queue有元素   
                              
                if(k!=0){                                      
                    
                    ArrayList<Integer> temp_list = stack.peek(); 
                    current = queue.poll();
                    k-=1;
                    temp_list.add(current.val);
                                    
                }else{
                                  
                    k=queue.size();
                    current = queue.poll();
                    k-=1;
                    ArrayList<Integer> temp_list = new ArrayList<Integer>();    //开启新链表
                    temp_list.add(current.val);
                    stack.push(temp_list);                   
                }
                
                System.out.print(current.val+" ");
                                 
                if(current.left!=null){
                    queue.offer(current.left);            
                }
                if(current.right!=null){
                    queue.offer(current.right);           
                }
            }
            
        }else{
            return result;
        }
        
        while(!stack.isEmpty()){
            result.add(stack.peek());
            stack.pop();
        }
        return result;
    }
}