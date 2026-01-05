class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int negs = 0;
        long minAbs = Integer.MAX_VALUE;
        long negSum = 0;
        long posSum = 0;
        int z = 0;
        for(int arr[] : matrix){
            for(int a : arr){
                if(a < 0){
                    negSum += a;
                    negs++;
                }
                else if(a == 0) z++;
                else posSum += a;
                if(minAbs > Math.abs(a)) minAbs = Math.abs(a);
            }
        }
        if(negs % 2 == 0 || z > 0) return posSum - negSum;
        long sum = posSum - negSum;
        return sum - 2l * minAbs;
        
    }
}
// -3 0 0
//  0 0 0
//  0 3 2