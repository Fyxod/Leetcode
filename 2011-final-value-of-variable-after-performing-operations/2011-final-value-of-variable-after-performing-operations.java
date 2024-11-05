class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String s : operations) {
            if (s.charAt(0) == '-' || s.charAt(1) == '-')
                X--;
            else
                X++;
        }
        return X;
    }
}