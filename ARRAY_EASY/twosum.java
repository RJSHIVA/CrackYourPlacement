public import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (map.containsKey(moreNeeded)) {
                ans[0] = map.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            map.put(num, i);
        }

        return ans;
    }
}