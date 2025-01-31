class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int k = n - 1;

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else { // nums[j] == 0
                swap(nums, j, i);
                i++;
                j++;
            }
        }
    }
}
