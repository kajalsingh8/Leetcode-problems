class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int flip = k;
        int max = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                flip--;
            }
            while(flip < 0){
                if(nums[left] == 0){
                    flip++;
                }
                left++;
            }
            max = Math.max(max, right - left + 1); 
        }
        return max;
    }
}