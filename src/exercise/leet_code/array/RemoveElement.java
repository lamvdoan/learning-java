package exercise.leet_code.array;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));

        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();


        int[] nums2 = {3,2,2,3};
        System.out.println(removeElement(nums2, 3));

        for (int i : nums2) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();


        int[] nums3 = {};
        System.out.println(removeElement(nums3, 5));

        for (int i : nums3) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();


        int[] nums4 = {3,2,2,3};
        System.out.println(removeElement(nums4, 5));

        for (int i : nums4) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();


        int[] nums5 = {3,3,3};
        System.out.println(removeElement(nums5, 3));

        for (int i : nums5) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();


        int[] nums6 = {5,4};
        System.out.println(removeElement(nums6, 5));

        for (int i : nums6) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();


        int[] nums7 = {5};
        System.out.println(removeElement(nums7, 5));

        for (int i : nums7) {
            System.out.print(i + " ");
        }
    }

    private static int removeElement2(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        int s = nums.length;

        while (i != j) {
            if (nums[i] == val) {
                while(nums[j] == val) {
                    j--;
                    s--;

                    if (i == j) {
                        return j;
                    }
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                s--;
            }

            i++;
        }

        return s;
    }

    private  static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
