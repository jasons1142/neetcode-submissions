class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = (right - left) * Math.min(heights[left], heights[right]);

        while (left < right) {
            if (((right - left) * Math.min(heights[left], heights[right])) > max) {
                max = (right - left) * Math.min(heights[left], heights[right]);
            }

            if (heights[right] < heights[left]) {
                right--;
            } else {
                left ++;
            }
        }

        return max;
    }
}
