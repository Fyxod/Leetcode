class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for(int a : nums){
            if(cnt1 == 0 && el2 != a){
                cnt1 = 1;
                el1 = a;
            }
            else if(cnt2 == 0 && el1 != a){
                cnt2 = 1;
                el2 = a;
            }
            else if (el1 == a) cnt1++;
            else if (el2 == a) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        cnt1 = 0; cnt2 = 0;
        for(int a : nums){
            if(el1 == a) cnt1++;
            else if(el2 == a) cnt2++;
        }

        int thresh = (int)(nums.length / 3) + 1;
        if(cnt1 >= thresh) ans.add(el1);
        if(cnt2 >= thresh) ans.add(el2);

        return ans;
    }
}