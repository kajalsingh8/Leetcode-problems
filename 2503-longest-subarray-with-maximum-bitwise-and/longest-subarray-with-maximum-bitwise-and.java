class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxBit = Integer.MIN_VALUE;
        for( int num : nums){
            maxBit = Math.max(maxBit, num );
        }
        int maxi = 1;
        int count = 0;
        int i =0;

    while(i<n){
        if(nums[i] == maxBit){
            while( i<n && nums[i++] == maxBit){
                count++;
            }
            maxi = Math.max(maxi , count);
            count =0;
        }else{
            i++;
        }
    }
      return maxi;
    }
}