package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import structure.ListNode;

//class ListNode {
//    int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//    }
// }
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
	        boolean flag = false;
	        if(head == null) {
	        	return false;
	        }
	        List<ListNode> pp = new ArrayList<ListNode>();
	        ListNode outflag = head;
	        ListNode inflag = head.next;
	        while(inflag != null) {
	        	if(inflag.next == null) {
	        		return false;
	        	}
	        	if(pp.contains(inflag)) {
	        		return true;
	        	}else {
	        		pp.add(inflag);
	        	}
	        	inflag = inflag.next;
	        }
	        return flag;
	    }
}
