class Solution {
    public int getSum(int a, int b) {
        return add(a, b);//return the value of the a,b 
    }

    public int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;//calcuate using the AND 
            a = a ^ b;//Calculate using the XOR 
            b = carry << 1;//shift the carry for the next iteration 
        }
        return a;//return the value of a 
    }
}
