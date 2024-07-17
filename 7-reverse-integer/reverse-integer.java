class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int ld = x % 10;
            
            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && ld > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && ld < -8)) return 0;
            
            rev = rev * 10 + ld;
            x /= 10;
        }
        
        return rev;
    }
}
