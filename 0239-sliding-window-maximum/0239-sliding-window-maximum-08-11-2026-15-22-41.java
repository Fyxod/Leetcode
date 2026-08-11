class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int len = n - k + 1;
        int ans[] = new int[len];
        int ind = 0;

        // for(int i = 0; i < k; i++){
        //     while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
        //     dq.addLast(i);
        // }
        // ans[ind++] = nums[dq.peekFirst()];
        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
            if(i - dq.peekFirst() == k) dq.removeFirst();
            if(i >= k - 1) ans[ind++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}