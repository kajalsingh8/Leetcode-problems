class Solution
{
    public int[] constructDistancedSequence(int n)
    {
        // Step 1: Initialize structures
    
        boolean[] map = new boolean[n + 1]; // To track used numbers
        int[] result = new int[n * 2 - 1]; // Final sequence array

        // Step 2: Fill the result array with -1
        Arrays.fill(result, -1);

        // Step 3: Start the recursive backtracking function
        solve(0, n, result, map);

        return result;
    }

    public boolean solve(int i, int n, int[] result, boolean[] map)
    {
        // Step 4: If we've reached the end, return true
        if (i >= result.length)
        {
            return true;
        } 

        // Step 5: If the position is occupied, move to the next index
        if (result[i] != -1)
        {
            return solve(i + 1, n, result, map);
        } 

        // Step 6: Try placing numbers from `n` to `1`
        for (int num = n; num >= 1; num--)
        {
            if (map[num])
            {
                continue; // Skip if already used
            } 

            // Step 7: Mark the number as used and place it
            map[num] = true;
            result[i] = num;

            if (num == 1)
            {
                // Step 8: Move forward with recursion if num is 1
                if (solve(i + 1, n, result, map))
                {
                    return true;
                } 
            } 
            else
            {
                int j = i + num;
                if (j < result.length && result[j] == -1)
                {
                    result[j] = num;

                    // Step 9: Continue solving recursively
                    if (solve(i + 1, n, result, map))
                    {
                        return true;
                    } 

                    // Step 10: Backtrack if solution is not found
                    result[j] = -1;
                }
            }

            // Step 11: Backtrack and try another number
            map[num] = false;
            result[i] = -1;
        }

        return false;
    }
}