class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int [] flowerbed2 = new int[flowerbed.length+2];
        System.arraycopy(flowerbed, 0, flowerbed2, 1, flowerbed.length);
        flowerbed2[0] = 0;
        flowerbed2[flowerbed2.length-1] = 0;
        int count = 0;
        for(int i = 0; i < flowerbed2.length; i++){
            int temp = 1;
            if(flowerbed2[i] == 0){
                i++;
                while(i < flowerbed2.length && flowerbed2[i] == 0){
                    temp++;
                    i++;
                }
                if(temp>=3){
                    if(temp%2 == 0)
                        temp--;
                count = count + (temp-1)/2;
                }
            }
        }
        return (count>=n);
    }
}