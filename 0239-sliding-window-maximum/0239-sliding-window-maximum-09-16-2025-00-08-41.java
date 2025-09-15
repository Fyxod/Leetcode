class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
        }
        list.add(nums[dq.peekFirst()]);
        for(int i = k; i < nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst() == i - k) dq.removeLast();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
            dq.addLast(i);
            list.add(nums[dq.peekFirst()]);
        }
        int ans[] = new int[list.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}