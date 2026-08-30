class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int start = j + 1, end = n - 1;
                int a = nums[i], b = nums[j];
                long t = (long)target - a - b;
                
                while(start < end){
                    int c = nums[start], d = nums[end];
                    if(c + d == t){
                        list.add(new ArrayList<>(Arrays.asList(a, b, c, d)));
                        start++; end--;
                        while(start <= end && nums[start] == c) start++;
                        while(start <= end && nums[end] == d) end--;
                    }
                    else if(c + d < t) start++;
                    else end--;
                }
            }
        }

        return list;
    }
}