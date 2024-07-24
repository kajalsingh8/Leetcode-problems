class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int minMaxSum = 0;
        for(int i =0;i<n/2;i++){
            minMaxSum = Math.max(minMaxSum,nums[i] + nums[n-1-i]);
        }
        return minMaxSum;
    }
}