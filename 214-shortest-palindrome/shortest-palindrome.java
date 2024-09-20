class Solution {
    public String shortestPalindrome(String s) {
        //revese string 
        int n = s.length();
        final String t = new StringBuilder(s).reverse().toString();
        //Iterate through the reversed strign 
        for(int i =0;i<n;i++ ){
            if(s.startsWith(t.substring(i))){
                return t.substring(0,i)+s;
            }
        } 
        return t + s ;
    }
}