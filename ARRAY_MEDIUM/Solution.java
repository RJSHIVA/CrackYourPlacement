class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int start = 0;
        int end   = n-1;
        int area =0;
        int max = 0 ;

        while(start<end){
            area = Math.min(height[start],height[end])*(end-start);

            if(area>max) max=area;

            if(Math.min(height[start],height[end])==height[start]){
                start++;
            }else{
                end--;
            }
        }

        return max;

    }
}