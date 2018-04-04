package CCI150;

import java.util.ArrayList;

public class EightQueen {
    public static void main(String[] args) {
        printPos();
    }

    public static void printPos() {
        ArrayList<Integer> map = new ArrayList<>();
        dfs(map, 0);
    }

    public static void dfs(ArrayList<Integer> path, int index) {
        if (index == 8) {
            for (int p : path) System.out.print(p + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < 8; i++) {
            path.add(i);
            if (!checkCollision(path, index, i)) dfs(path, index + 1);
            path.remove(path.size() - 1);
        }

    }

    public static boolean checkCollision(ArrayList<Integer> path, int row, int col) {
        for (int i = 0; i < path.size() - 1; i++) {
            if (i == row || path.get(i) == col || i + path.get(i) == row + col || i - path.get(i) == row - col) return true;
        }
        return false;
    }
}
