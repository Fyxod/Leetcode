class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while(left <= right){
            if(leftMax < rightMax){
                if(height[left] < leftMax) ans += leftMax - height[left];
                else leftMax = height[left];
                left++;
            }
            else{
                if(height[right] < rightMax) ans += rightMax - height[right];
                else rightMax = height[right];
                right--;
            }
        }
        return ans;
    }
}