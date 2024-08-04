class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int count = 0; // Reset count for each element
            
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) { // Correctly compare elements
                    count++;
                }
            }
            
            if (count == 1) { // Check if the element appears only once
                return nums[i]; // Return the element that appears only once
            }
        }
        
        return -1; // This should never be reached since the problem guarantees one single number
    }
}
