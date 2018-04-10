package CCI150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BUPT_ACM_PRE_H {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String nAndM = in.nextLine();
//            String[] res = nAndM.split(" ");
//            int n = Integer.parseInt(res[0]), m = Integer.parseInt(res[1]);
//            if (m == 0 || n == 0) System.out.println(0);
//            ArrayList<String> map = new ArrayList<>();
//            while (n > 0) {
//                map.add(in.nextLine()); --n;
//            }
//            System.out.println(foo(n, m, map));
//        }
        ArrayList<String> map = new ArrayList<>();
        map.add("S.#"); map.add("URT");
        System.out.println(foo(2, 3, map));
    }

    public static class Node{
        public int x, y;
        public char dir;
        public Node(int r, int c, char d){
            x = r; y = c; dir = d;
        }
    }
    public static int foo(int n, int m, ArrayList<String> map) {
        Queue<Node> q = new LinkedList<>(), next = new LinkedList<>();
        boolean found = false;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).charAt(j) == 'S') {
                    q.offer(new Node(i, j, 'U')); q.offer(new Node(i, j, 'D'));
                    q.offer(new Node(i, j, 'L')); q.offer(new Node(i, j, 'R'));
                    found = true; break;
                }
            }
            if (found) break;
        }
        int layer = 0;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                Node cur = q.poll();
                char curChar = map.get(cur.x).charAt(cur.y);
                if (curChar == 'T') return layer;
                else if (curChar == '.' || curChar == 'S') {
                    if (cur.dir == 'R' && cur.y + 1 < m ) next.offer(new Node(cur.x, cur.y + 1, cur.dir));
                    else if (cur.dir == 'L' && cur.y - 1 >= 0 ) next.offer(new Node(cur.x, cur.y - 1, cur.dir));
                    else if (cur.dir == 'U' && cur.x - 1 >= 0 ) next.offer(new Node(cur.x - 1, cur.y, cur.dir));
                    else if (cur.dir == 'D' && cur.x + 1 < n ) next.offer(new Node(cur.x + 1, cur.y, cur.dir));
                } else if (curChar == '#') continue;
                else {
                    if (curChar == 'L' && cur.y - 1 >= 0 ) next.offer(new Node(cur.x, cur.y - 1, curChar));
                    else if (curChar == 'R' && cur.y + 1 < m ) next.offer(new Node(cur.x, cur.y + 1, curChar));
                    else if (curChar == 'U' && cur.x - 1 >= 0 ) next.offer(new Node(cur.x - 1, cur.y, curChar));
                    else if (curChar == 'D' && cur.x + 1 < n ) next.offer(new Node(cur.x + 1, cur.y, curChar));
                }
            }
            Queue<Node> tmp = q; q = next; next = tmp; ++layer;
        }
        return -1;
    }
}
