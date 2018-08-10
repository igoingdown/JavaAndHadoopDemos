package interview.NetEase.AIRE.Online2;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        int n, m;
        HashMap<String, Integer> name2authority = new HashMap<>();
        HashMap<String, Integer> name2state = new HashMap<>();
        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        SortedSet<GroupMember> group = new TreeSet<>(new GroupMemberComparator());
        for (int i = 0; i < n; i++) {
            String[] authorityAndName = in.nextLine().split(" ");
            group.add(new GroupMember(Integer.parseInt(authorityAndName[0]), authorityAndName[1]));
            name2authority.put(authorityAndName[1], Integer.parseInt(authorityAndName[0]));
            name2state.put(authorityAndName[1], 0);
        }
        m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < m; i++) {
            String[] nameAndOperation = in.nextLine().split(" ");
            int operation = Integer.parseInt(nameAndOperation[1]);
            String name = nameAndOperation[0];
            int authority = name2authority.get(name);
            int state = name2state.get(name);
            group.remove(new GroupMember(state, authority, name));
            group.add(new GroupMember(operation, authority, name));
            name2state.put(name, operation);
        }
        for (GroupMember member : group) {
            System.out.println(member.name);
        }
    }
    public static class GroupMemberComparator implements Comparator<GroupMember> {
        @Override
        public int compare(GroupMember o1, GroupMember o2) {
            if (o1.onLineState != o2.onLineState) return o2.onLineState - o1.onLineState;
            if (o1.authority != o2.authority) return o2.authority - o1.authority;
            return o1.name.compareTo(o2.name);
        }
    }

    public static class GroupMember {
        public int onLineState;
        public int authority;
        public String name;
        public GroupMember(int a, String n) {
            authority = a;
            name = n;
            onLineState = 0;
        }

        public GroupMember(int o, int a, String n) {
            onLineState = o;
            authority = a;
            name = n;
        }
    }
}
