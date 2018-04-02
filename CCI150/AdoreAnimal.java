package CCI150;

import java.util.LinkedList;
import java.util.Scanner;

public class AdoreAnimal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) enqueue(in.nextInt());
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(dequeAny());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(dequeCat());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(dequeDog());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    private static int id = 0;
    private static LinkedList<Integer> dogs = new LinkedList<>();
    private static LinkedList<Integer> cats = new LinkedList<>();

    public static void enqueue(int isDog) {
        if (isDog == 0) dogs.addLast(++id);
        else cats.addLast(++id);
    }

    public static int dequeAny() throws Exception {
        if (dogs.isEmpty() && cats.isEmpty()) throw new Exception("animal pool is empty");
        if (dogs.isEmpty()) return cats.poll();
        if (cats.isEmpty()) return dogs.poll();
        return dogs.getFirst() < cats.getFirst() ? dogs.poll() : cats.poll();
    }

    public static int dequeCat() throws Exception {
        if (cats.isEmpty()) throw new Exception("cat pool is empty");
        return cats.poll();
    }

    public static int dequeDog() throws Exception {
        if (dogs.isEmpty()) throw new Exception("dog pool is empty");
        return dogs.poll();
    }
}
