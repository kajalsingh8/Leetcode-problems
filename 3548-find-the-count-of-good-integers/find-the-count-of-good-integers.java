class Solution {
    
   
    public long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i; 
        }
        return result; // Return the final factorial value
    }

   
    public void generatePalindromes(char[] currentNumber, int index, List<String> validPalindromes, int k) {
        // Base case: if we've filled the entire number from both ends
        if (index >= (currentNumber.length + 1) / 2) {
            String palindrome = new String(currentNumber); // Convert char[] to string
           
            if (Long.parseLong(palindrome) % k == 0) {
                validPalindromes.add(palindrome);
            }
            return;
        }

        
        if (index != 0) {
            currentNumber[index] = '0';
            currentNumber[currentNumber.length - 1 - index] = '0'; // Mirror placement
            generatePalindromes(currentNumber, index + 1, validPalindromes, k); // Move to next index
        }

      
        for (char c = '1'; c <= '9'; c++) {
            currentNumber[index] = c;
            currentNumber[currentNumber.length - 1 - index] = c; // Mirror the digit
            generatePalindromes(currentNumber, index + 1, validPalindromes, k); // Recurse deeper
        }
    }

    
    public long countGoodIntegers(int n, int k) {
        List<String> validPalindromes = new ArrayList<>(); // Stores all valid palindromes
        char[] basePalindrome = new char[n]; // Initial base: all zero characters
        Arrays.fill(basePalindrome, '0'); // Fill it with '0's
        generatePalindromes(basePalindrome, 0, validPalindromes, k); // Start building palindromes

        Set<String> uniquePatterns = new HashSet<>(); // Store unique frequency patterns

    
        for (String palindrome : validPalindromes) {
            int[] freq = new int[10]; // Array to count digits 0 to 9
            for (char ch : palindrome.toCharArray()) {
                freq[ch - '0']++; // Increase count for digit
            }

            StringBuilder pattern = new StringBuilder();
            for (int f : freq) {
                pattern.append((char) ('a' + f)); // Convert frequency number to a letter
            }

            uniquePatterns.add(pattern.toString()); // Add the pattern to the set (no duplicates)
        }

        long totalPermutations = factorial(n); // Total permutations of n digits
        long totalValidPermutations = 0; // We'll accumulate the final answer here

        // \U0001f50d For each unique digit pattern, calculate how many valid permutations it can make
        for (String pattern : uniquePatterns) {
            long permutations = totalPermutations;

            for (char ch : pattern.toCharArray()) {
                permutations /= factorial(ch - 'a'); // Convert char back to count (reverse of earlier encoding)
            }

            if (pattern.charAt(0) != 'a') { // Means we have leading zeros
                int zeroCount = pattern.charAt(0) - 'a' - 1; // Remove 1 zero from front
                long invalidPerms = factorial(n - 1); // First digit can't be 0, fix it and permute rest

                for (int j = 1; j < pattern.length(); j++) {
                    invalidPerms /= factorial(pattern.charAt(j) - 'a');
                }

                invalidPerms /= factorial(zeroCount); // Adjust for leading zero count
                permutations -= invalidPerms; // Subtract invalid ones
            }

            totalValidPermutations += permutations; // Add valid permutations to total
        }

        return totalValidPermutations; // Return final answer
    }
}