package TwoPointer;

public class LeetCode234 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(new LeetCode234().isPalindrome(listNode1));
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pHead = slow.next;
        ListNode pNext = pHead.next;

        pHead.next = null;
        while (pNext != null) {
            ListNode tmp = pNext.next;
            pNext.next = pHead;
            pHead = pNext;
            pNext = tmp;
        }

        fast = pHead;
        slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
