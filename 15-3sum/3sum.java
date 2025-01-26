class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break; 
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    while (l+1 <= r && arr[l] == arr[l+1]) l++;
                    l++;
                    r--;
                }
            }
            while (i+1 < n && arr[i+1] == arr[i]) i++; 
        }
        return ans;
    }
}