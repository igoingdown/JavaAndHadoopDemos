package CCI150;

import java.util.HashSet;

public class DeleteDuplicateNodeInList {
    public static void main(String[] args) {
        ListNode head = null;
        for (int i = 0; i < 10; i++) {
            ListNode cur = new ListNode(i / 3);
            cur.next = head;
            head = cur;
        }
        deleteDuplicateNodeHash(head);
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " "); tmp = tmp.next;
        }
        System.out.println();
        head = null;
        for (int i = 0; i < 10; i++) {
            ListNode cur = new ListNode(i / 3);
            cur.next = head;
            head = cur;
        }
        deleteDuplicateNode(head);
        tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " "); tmp = tmp.next;
        }

    }

    public static void deleteDuplicateNode(ListNode head) {
        while (head != null) {
            ListNode cur = head.next, pre = head;
            while (cur != null) {
                if (cur.val == head.val) pre.next = cur.next;
                else pre = cur;
                cur = cur.next;
            }
            head = head.next;
        }
    }

    public static void deleteDuplicateNodeHash(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = null;
        while (head != null) {
            if (set.contains(head.val)) pre.next = head.next;
            else {
                set.add(head.val); pre = head;
            }
            head = head.next;
        }
    }
}
