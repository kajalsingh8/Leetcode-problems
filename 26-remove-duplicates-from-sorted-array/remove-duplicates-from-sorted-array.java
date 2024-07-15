class Solution {
    public int removeDuplicates(int[] nums) {
            
        int len = nums.length;
        
        if(len == 0){
            
            return 0;
        }
        
        int index = 1;

        for(int i = 1; i < len; i++){
            
            if(nums[i] != nums[i-1]){
                        
                nums[index] = nums[i];
                index++;
            }
        }
        
        
        return index;
    }
}