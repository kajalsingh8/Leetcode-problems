class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int target = 0, targetlen =  str2.length();
        for(char currChar : str1.toCharArray()){
            if(target < targetlen && (str2.charAt(target) - currChar + 26 ) % 26 <=1){
                target++;
            }
        }
        return target == targetlen;
    }
}