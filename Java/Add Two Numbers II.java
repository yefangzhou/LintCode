//进位方向错了，应该是个位进十位的。
//你的code是十位进个位的。
//只要把stack改成queue就行了。
//亲测，可行


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if (l1 == null && l2 == null) {
    		return null;
    	} else if (l1 == null || l2 == null) {
    		return l1 == null ? l2 : l1;
    	}

    	Queue<ListNode> result = new LinkedList<ListNode>();
    	Queue<ListNode> s1 = new LinkedList<ListNode>();
    	Queue<ListNode> s2 = new LinkedList<ListNode>();

    	while (l1 != null) {
    		s1.add(l1);
    		l1 = l1.next;
    	}

    	while (l2 != null) {
    		s2.add(l2);
    		l2 = l2.next;
    	}

    	int carrier = 0;
    	while(!s1.isEmpty() || !s2.isEmpty()){
    		int sum = 0;
    		if (!s1.isEmpty() && !s2.isEmpty()) {
    			sum += s1.poll().val + s2.poll().val;
    		} else if (!s1.isEmpty()) {
    			sum += s1.poll().val;
    		} else {
    			sum += s2.poll().val;
    		}
    		result.add(new ListNode((sum + carrier) % 10));
    		carrier = (sum + carrier) / 10; 
    	}
    	if (carrier == 1) {
    		result.add(new ListNode(carrier));
    	}

    	//return results:
    	ListNode node = new ListNode(0);
    	ListNode dummy = node;
    	while (!result.isEmpty()) {//219
    		node.next = result.poll();
    		node = node.next;
    	}

    	return dummy.next;
    }//addTwoNumbers
}//class
