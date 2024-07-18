class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        // Calculate the sum of the first k elements
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;
        // Sliding window to consider taking elements from the end
        for (int i = 0; i < k; i++) {
            currentSum = currentSum - nums[k - 1 - i] + nums[n - 1 - i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
