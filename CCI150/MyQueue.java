package CCI150;

public class MyQueue {
    private ListNode head, tail;
    public MyQueue() {
        head = null; tail = null;
    }
    public void push(int x) {
        ListNode cur = new ListNode(x);
        if (head == null) {
            tail = cur; head = cur;
        } else {
            tail.next = cur; tail = cur;
        }
    }

    public int pop() throws NullPointerException {
        if (head != null) {
            int res = head.val;
            if (tail == head) tail = null;
            head = head.next;
            return res;
        } else throw new NullPointerException();
    }
}
