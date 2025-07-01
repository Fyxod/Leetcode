class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int arr[] = new int[26];
            for(int j = i; j < s.length(); j++){
                int index = s.charAt(j) - 'a';
                arr[index]++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int a : arr){
                    max = Math.max(max, a);
                    if(a > 0 && a < min){
                        min = a;
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}