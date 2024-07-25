class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        // boolean swapped;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     swapped = false;
        //     for (int j = 0; j < nums.length - 1 - i; j++) {
        //         if (nums[j] > nums[j + 1]) {
        //             // Swap nums[j] and nums[j + 1]
        //             int temp = nums[j];
        //             nums[j] = nums[j + 1];
        //             nums[j + 1] = temp;
        //             swapped = true;
        //         }
        //     }
        //     // If no two elements were swapped by inner loop, then break
        //     if (!swapped) {
        //         break;
        //     }
        // }
        return nums;
    }
}    