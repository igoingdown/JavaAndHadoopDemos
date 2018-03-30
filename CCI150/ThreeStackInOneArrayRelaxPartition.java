package CCI150;

public class ThreeStackInOneArrayRelaxPartition {

    public static void main(String[] args) throws Exception {
        push(0, 10);
        push(0, 10);
        push(1, 20);
        push(2, 30);
        System.out.println(pop(1));
        push(0, 10);
        push(0, 10);
        push(0, 15);
        for (int i = 0; i < 5; i++) System.out.println(pop(0));
    }

    public static class StackData{
        public int start, top, size = 0, capicity;
        public StackData(int _start, int _capicity) {
            start = _start; top = start - 1; capicity = _capicity;
        }
        public boolean isWithinStack(int index, int total_size) {
            if (start <= index && index < start + capicity) return true;
            else if (start + capicity > total_size && index < (start + capicity) % total_size) return true;
            return false;
        }
    }

    private static int stack_num = 3;
    private static int default_size = 4;
    private static int total_size = stack_num * default_size;
    private static StackData[] stacks = {new StackData(0, default_size), new StackData(default_size, default_size), new StackData(2 * default_size, default_size)};
    private static int[] buffer = new int[total_size];

    public static int nextElement(int index) {
        if (index + 1 == total_size) return 0;
        return index + 1;
    }

    public static int preElement(int index) {
        if (index == 0) return total_size - 1;
        return index - 1;
    }

    public static void push(int stack_index, int x) throws Exception {
        if (totalElementCount() == total_size) throw new Exception("buffer filled!");
        else {
            if (stacks[stack_index].size >= stacks[stack_index].capicity) {
                expand(stack_index);
            }
            stacks[stack_index].top = nextElement(stacks[stack_index].top);
            buffer[stacks[stack_index].top] = x;
            ++stacks[stack_index].size;
        }
    }

    public static void expand(int stack_index) {
        int nextStack = (stack_index + 1) % stack_num;
        shift(nextStack);
        ++stacks[stack_index].capicity;
        }

    public static void shift(int stack_index) {
        if (stacks[stack_index].size >= stacks[stack_index].capicity) {
            int nextStack = (stack_index + 1) % stack_num;
            shift(nextStack);
            ++stacks[stack_index].capicity;
        }

        for (int i = (stacks[stack_index].start + stacks[stack_index].capicity - 1) % total_size; stacks[stack_index].isWithinStack(i, total_size); i = preElement(i))
            buffer[i] = preElement(i);
        buffer[stacks[stack_index].start] = 0;
        stacks[stack_index].start = nextElement(stacks[stack_index].start);
        stacks[stack_index].top = nextElement(stacks[stack_index].top);
        --stacks[stack_index].capicity;
    }

    public static int pop(int stack_index) throws Exception {
        if (stacks[stack_index].size == 0) throw new Exception("stack " + stack_index + " is empty!");
        int res = buffer[stacks[stack_index].top];
        buffer[stacks[stack_index].top] = 0;
        --stacks[stack_index].size;
        stacks[stack_index].top = preElement(stacks[stack_index].top);
        return res;
    }

    public static int totalElementCount() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }

}
