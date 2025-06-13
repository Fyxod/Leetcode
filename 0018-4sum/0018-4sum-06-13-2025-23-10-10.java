class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int outer = 0;

        while(outer < nums.length){
            int i = outer + 1;
            int a = nums[outer];
            while(i < nums.length){
                int b = nums[i];
                
                int j = i + 1;
                int k = nums.length - 1;

                while(j < k){
                    int c = nums[j];
                    int d = nums[k];
                    long sum = a;
                    sum += b;
                    sum += c;
                    sum += d;

                    if(sum == target){
                        list.add(new ArrayList<>(Arrays.asList(a, b, c, d)));
                        while(j < k && nums[j] == c) j++;
                        while(j < k && nums[k] == d) k--;
                    }
                    else if(sum > target){
                        k--;
                    }
                    else{
                        j++;
                    }
                }
                while(i < nums.length && nums[i] == b) i++;
            }
            while(outer < nums.length && nums[outer] == a) outer++;
        }
        return list;
    }
}