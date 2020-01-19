package exercise.cracking.ch8;

public class MagicIndex {
    public static void main(String[] args) {
        System.out.println("1, " + magicIndexBruteForce(new int[]{-9, 1, 1, 1, 3, 5, 8, 9}));
        System.out.println("5, " + magicIndexBruteForce(new int[]{-9, -5, 0, 1, 3, 5, 8, 9}));
        System.out.println("3, " + magicIndexBruteForce(new int[]{-3, -1, 3, 3, 9, 10}));
        System.out.println("-1, " + magicIndexBruteForce(new int[]{-10, -5, 0, 1, 3, 9, 10, 17}));
        System.out.println("2, " + magicIndexBruteForce(new int[]{-10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13}));
    }

    private static int magicIndexBruteForce(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array[i]) {
                return i;
            }
        }

        return -1;
    }
}
