package exercise.optimization;

public class CountPrime {
    public static void main(String[] args) {
        System.out.println("0, " + countPrime(1));
        System.out.println("1, " + countPrime(3));
        System.out.println("2, " + countPrime(5));
        System.out.println("4, " + countPrime(10));
        System.out.println("4, " + countPrime(11));
        System.out.println("5, " + countPrime(12));
        System.out.println("6, " + countPrime(14));
    }

    private static int countPrime(int n) {
        boolean[] numbers = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (numbers[i]) continue;

            count++;

            for (int j = i; j < n; j = j + i) {
                numbers[j] = true;
            }
        }

        return count;
    }
}
