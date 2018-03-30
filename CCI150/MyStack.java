package CCI150;

public class MyStack {
    private ListNode top;
    public MyStack() {
        top = null;
    }
    public int pop() throws NullPointerException {
        int res = -1;
        if (top != null) {
            res = top.val; top = top.next;
        } else throw new NullPointerException();
        return res;
    }

    public void push(int x) {
        ListNode cur = new ListNode((x));
        cur.next = top;
        top = cur;
    }
    public int peek() throws NullPointerException {
        if (top != null) {
            return top.val;
        } else throw new NullPointerException();
    }
}
