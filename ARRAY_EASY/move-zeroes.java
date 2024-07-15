class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;  // Pointer for the position to place the next non-zero element
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(nums, right, left);
                left++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
