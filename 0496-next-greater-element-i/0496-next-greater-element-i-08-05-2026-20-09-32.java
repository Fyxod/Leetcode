class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int n = nums2.length;
        int m = nums1.length;

        int ans[] = new int[m];

        for(int j = n - 1; j >= 0; j--){
            if(!map.containsKey(nums2[j])){
                stack.push(nums2[j]);
                continue;
            }
            int ind = map.get(nums2[j]);
            while(!stack.isEmpty() && stack.peek() <= nums2[j]) stack.pop();
            ans[ind] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[j]);
        }

        return ans;
    }
}