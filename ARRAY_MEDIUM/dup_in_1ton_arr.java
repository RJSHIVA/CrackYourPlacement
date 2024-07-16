import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Calculate the index by taking the absolute value of the current element and subtracting 1
            int index = Math.abs(nums[i]) - 1;
            
            // Check if the value at this index is already negative
            if (nums[index] < 0) {
                // If it is negative, the number has been seen before, so it's a duplicate
                ans.add(index + 1);
            } else {
                // Otherwise, negate the value at this index to mark it as seen
                nums[index] = -nums[index];
            }
        }
        
        return ans;
    }
}