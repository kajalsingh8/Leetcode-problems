class Solution {
    public int getSum(int a, int b) {
        return add(a, b);
    }

    public int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b; 
            b = carry << 1; 
        }
        return a;//return the value of a 
    }
}
