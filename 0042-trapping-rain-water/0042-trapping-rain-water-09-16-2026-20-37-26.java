class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;

        int ans = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax <= rightMax){
                ans += leftMax - height[left++];
            }
            else{
                ans += rightMax - height[right--];
            }
        }

        return ans;
    }
}