class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        int[] arr=new int[3];

        int i=n-1, j=n-1;
        while(i>=0 && j>=0){
            arr[s.charAt(i)-'a']++;

            while(arr[0]>0 && arr[1]>0 && arr[2]>0){                  
                    cnt+=i+1;  
                    arr[s.charAt(j)-'a']--;
                    j--;                
            }
            i--;
        }

        return cnt;
    }

}