package CCI150;

import java.util.LinkedList;
import java.util.Stack;

public class SetOfStacks {
    private static LinkedList<Stack<Integer>> stackList = null;
    private static final Integer capicity = 100;

    public static void main(String[] args) {
        SetOfStacks s = new SetOfStacks();
        s.push(10);
        try {
            s.pop();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        for (int i = 0; i < 1000; i++) s.push(i);
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(s.pop());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        try {
            System.out.println(s.popAt(10));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println(s.popAt(8));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void push(Integer x) {
        if (stackList == null) stackList = new LinkedList<>();
        if (stackList.isEmpty() || stackList.getLast().size() == capicity) stackList.add(new Stack<>());
        stackList.getLast().push(x);
    }

    public static int pop() throws Exception {
        if (stackList == null || stackList.isEmpty()) throw new Exception("stack set is empty!");
        int res = stackList.getLast().pop();
        if (stackList.getLast().isEmpty()) stackList.removeLast();
        return res;
    }

    public static int popAt(int index) throws Exception {
        if (index < 0) throw new Exception("index overflow");
        if (stackList == null || stackList.isEmpty()) throw new Exception("stack set is empty!");
        if (stackList.size() <= index) throw new Exception("index overflow!");
        int res = stackList.get(index).pop();
        if (stackList.get(index).isEmpty()) stackList.remove(index);
        return res;
    }
}
