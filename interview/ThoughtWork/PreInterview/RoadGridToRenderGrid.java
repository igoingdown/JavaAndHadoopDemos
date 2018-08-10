package interview.ThoughtWork.PreInterview;

import java.util.Arrays;
import java.util.Scanner;

public class RoadGridToRenderGrid {
    private static char[][] renderGrid = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            StringBuilder builder = new StringBuilder();
            if (in.hasNext()) builder.append(in.nextLine());
            builder.append("\n");
            if (in.hasNext()) builder.append(in.nextLine());
            Create(builder.toString());
            if (renderGrid != null) render();
        }
    }

    public static void render() {
        if (renderGrid == null) {
            System.out.println("grid is null!");
            return;
        }
        int m = renderGrid.length, n = renderGrid[0].length;
        String wall = "[W]", road = "[R]";
        for (int i = 0; i < m; i++) {
            for (int j =0 ; j < n; j++) {
                if (renderGrid[i][j] == '0') {
                    if (j + 1 < n) System.out.printf("%s ", wall);
                    else System.out.printf("%s", wall);
                } else {
                    if (j + 1 < n) System.out.printf("%s ", road);
                    else System.out.printf("%s", road);
                }
            }
            System.out.println();
        }
    }

    public static void Create(String command) {
        renderGrid = null;
        String[] lines = command.split("\\n");
        if (lines.length != 2) {
            System.out.println("Incorrect command format");
            return;
        }

        String[] rowAndColumn = lines[0].split(" ");
        if (rowAndColumn.length != 2) {
            System.out.println("Incorrect command format");
            return;
        }
        int r = -1, c = -1;
        try {
            r = Integer.parseInt(rowAndColumn[0]);
            c = Integer.parseInt(rowAndColumn[1]);
        } catch (Exception e) {
            System.out.println("Invalid number format");
            return;
        }
        if (r <= 0 || c <= 0) {
            System.out.println("Number out of range");
            return;
        }
        int mazeRow = r * 2 + 1, mazeColumn = c * 2 + 1;
        renderGrid = new char[mazeRow][mazeColumn];
        for (int i = 0; i < mazeRow; i++) Arrays.fill(renderGrid[i], '0');
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) renderGrid[i * 2 + 1][j * 2 + 1] = 1;
        }
        for (String connection : lines[1].split(";")) {
            String[] grids = connection.split(" ");
            if (grids.length != 2) {
                System.out.println("Incorrect command format");
                return;
            }
            String[] pointOneXandY = grids[0].split(",");
            if (pointOneXandY.length != 2) {
                System.out.println("Incorrect command format");
                return;
            }
            int x1 = -1, y1 = -1;
            try {
                x1 = Integer.parseInt(pointOneXandY[0]);
                y1 = Integer.parseInt(pointOneXandY[1]);
            } catch (Exception e) {
                System.out.println("Invalid number format");
                return;
            }
            String[] pointTwoXandY = grids[1].split(",");
            if (pointTwoXandY.length != 2) {
                System.out.println("Incorrect command format");
                return;
            }
            int x2 = -1, y2 = -1;
            try {
                x2 = Integer.parseInt(pointTwoXandY[0]);
                y2 = Integer.parseInt(pointTwoXandY[1]);
            } catch (Exception e) {
                System.out.println("Invalid number format");
                return;
            }

            if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 || x1 >= r || x2 >= r || y1 >= c || y2 >= c) {
                System.out.println("Number out of range");
                return;
            }
            if (Math.abs((long) x1 - x2) == 1 && y1 == y2) {
                renderGrid[Math.max(x1, x2) * 2][2 * y1 + 1] = '1';
            } else if (Math.abs((long) y1 - y2) == 1 && x1 == x2) {
                renderGrid[Math.max(y1, y2) * 2][2 * x1 + 1] = '1';
            } else {
                System.out.println("Number out of range");
                return;
            }
        }
    }

}
