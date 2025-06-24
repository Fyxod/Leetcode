class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int arr[] = new int[m + n];

        int p = 0;
        int q = 0;
        int index = 0;

        while(p < m && q < n){
            if(nums1[p] < nums2[q]){
                arr[index++] = nums1[p++];
            }
            else{
                arr[index++] = nums2[q++];
            }
        }

        for(int i = p; i < m; i++){
            arr[index++] = nums1[i];
        }

        for(int i = q; i < n; i++){
            arr[index++] = nums2[i];
        }
        
        int total = m + n;
        
        if(total % 2 == 0){
            return (double)(arr[total / 2] + arr[total / 2 - 1]) / 2;
        }
        else{
            return arr[index / 2];
        }
    }
}