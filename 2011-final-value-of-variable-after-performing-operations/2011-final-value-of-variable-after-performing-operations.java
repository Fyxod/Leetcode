class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String s : operations) {
            if (s.contains("-"))
                X--;
            else
                X++;
        }
        return X;
    }
}