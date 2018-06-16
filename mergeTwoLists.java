package solution;

public class Solution {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// 其中有一空，合并之后则为另一个
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		
        ListNode result;
        ListNode head1;
        ListNode head2;
        
        //避免头指针不确定，固定让第一个元素小的作为被插入链表
        if(l1.val<=l2.val){
            head1 = l1;
            head2 = l2;
            result = l1;
        }else{
            head1 = l2;
            head2 = l1;
            result = l2;
        }
        
        // 被插链表当前指针有下一个元素，目前待插入元素不为空
        while(head1.next!=null&&head2!=null){
        	
        	ListNode insert = head2;
            
            if(head2.val>=head1.val&&head2.val<head1.next.val){
            	//找到插入位置了，移动指针，以便插下一个元素
            	head2 = head2.next;
                
                ListNode temp = head1.next;
                head1.next = insert;
                insert.next = temp;
                
                //被插入指针指向插入的新元素，便于后续遍历
                head1 = head1.next;
                
            }else{
            	//继续向下寻找插入位置
                head1=head1.next;
            }
        }
        
        if(head1.next==null&&head2!=null){
        	// 补齐后续被插入链表
            head1.next=head2;
        }
        return result;
    }
	
	public void print_link(ListNode p) {
		String s = "";
		while(p.next!=null) {
			s+=Integer.toString(p.val)+"-->";
			p = p.next;
		}
		s+=Integer.toString(p.val);
		System.out.println(s);
	}


	public static void main(String[] args) {
		Solution sol = new Solution();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		
//		sol.print_link(l1);
//		sol.print_link(l2);
		
		ListNode result =  sol.mergeTwoLists(l1,l2);
		sol.print_link(result);
		

	}

}
