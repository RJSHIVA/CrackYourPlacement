class Solution {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
     
   public void twoSum(int[] nums, int target, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[i]);
                temp.add(nums[j]);
                res.add(temp);

                // Move pointers to avoid duplicates
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;

                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        if (n < 3) return res;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            int target = -nums[i];
            twoSum(nums, target, i + 1, n - 1);
        }

        return res;
    }

}