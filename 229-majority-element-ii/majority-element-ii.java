class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //at first we create a list to stotore the value of answer
        List<Integer> ls = new ArrayList<>();
        //then we create a hashmap 
         HashMap< Integer,Integer> mp = new HashMap<>();
         //we define the minimum critera so that we can check if the number is accoures more than the minimum count 
        int mini = (int)(nums.length/3) +1;
        //iterate through the array 
        for(int i = 0; i<nums.length; i++){
            //put the value in the map
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            //we will check if the array value is equal to the minimum critera and list cannot contains the same value in the array 
            if(mp.get(nums[i]) == mini &&  !ls.contains(nums[i])){
                //then we add the value to the list 
                ls.add(nums[i]);
            }

        }
        //at the end we return the answer or list in which we store the answer value 
        return ls;
    }
}