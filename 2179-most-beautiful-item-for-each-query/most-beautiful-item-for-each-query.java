class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        
        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[queries.length];
        int maxBeauty = 0;
        int i = 0;

        for (int[] queryWithIndex : queriesWithIndex) {
            int query = queryWithIndex[0];
            int index = queryWithIndex[1];

           
            while (i < items.length && items[i][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[i][1]);
                i++;
            }

            // Store the max beauty for this query
            result[index] = maxBeauty;
        }
        return result;
    }
}