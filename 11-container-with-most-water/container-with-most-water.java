class Solution {
    public int maxArea(int[] height) {
        int ptr1 = 0, ptr2 = height.length-1;
        int water = 0;

        while(ptr1 < ptr2){
            if(height[ptr1] < height[ptr2]){
                water = Math.max(water, height[ptr1] * (ptr2 - ptr1));
                ptr1++;
            }
            else{
                water = Math.max(water, height[ptr2] * (ptr2 - ptr1));
                ptr2--;
            }
        }
        return water;
    }
}