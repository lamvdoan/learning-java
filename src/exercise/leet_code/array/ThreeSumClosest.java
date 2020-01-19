package exercise.leet_code.array;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] numbers = {-1, 2, 1, -4, 9, 4, 2, 4, 6, 3};
        System.out.println("Answer: " + threeSumClosest(numbers, 10));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = 99;
        boolean found = false;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (!found) {
                        found = true;
                        closest = sum;
                    } else if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        System.out.println("******************");
                        System.out.println(sum);
                        System.out.println(Math.abs(sum - target));
                        System.out.println("******************");

                        closest = sum;
                    }
                }
            }
        }

        return closest;
    }
}
