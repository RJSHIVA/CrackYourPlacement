import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1); // To handle the case when the subarray itself is equal to k

        for (int num : nums) {
            sum += num; // Add current number to the running sum
            
            if (prefixSumCounts.containsKey(sum - k)) {
                cnt += prefixSumCounts.get(sum - k); // Count the number of valid subarrays
            }
            
            // Update the count of the current prefix sum
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum, 0) + 1);
        }
        
        return cnt;
    }
}
