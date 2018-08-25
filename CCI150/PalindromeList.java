package CCI150;

import java.util.Stack;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode head = null;
        for (int i = 0; i < 10; i++) {
            ListNode cur = new ListNode(i / 3);
            cur.next = head;
            head = cur;
        }
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) System.out.print(tmp.val + " ");
        System.out.println();
        if (isPalindrome(head)) System.out.println("Y");
        else System.out.println("N");
        if (isPalindromeStack(head)) System.out.println("y");
        else System.out.println("n");
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode reversed = reverseList(head);
        while (head != null && reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next; reversed = reversed.next;
        }
        return true;
    }

    public static boolean isPalindromeStack(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next; fast = fast.next.next;
        }
        if (stack.isEmpty()) return true;
        if (fast != null && fast.next == null) slow = slow.next;
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            if (cur.val != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = newHead;
            newHead = cur;
            head = head.next;
        }
        return newHead;
    }

}
