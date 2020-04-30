package linkedlist;

import java.util.ArrayList;

public class ReverseList {
    public static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = four;
        System.out.println(printListFromTailToHead(first));
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = reverbe(listNode);
        return forEach(head);
    }

    private static ListNode reverbe(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode cur = null;
        ListNode next = listNode;
        ListNode tmp = next.next;
        while (next != null) {
            next.next = cur;
            cur = next;
            next = tmp;
            if (next != null) {
                tmp = next.next;
            }
        }
        return cur;
    }

    private static ArrayList<Integer> forEach(ListNode listNode) {
        ListNode cur = listNode;
        ArrayList<Integer> result = new ArrayList<>();
        while (cur != null) {
            result.add(cur.value);
            cur = cur.next;
        }
        return result;
    }
}
