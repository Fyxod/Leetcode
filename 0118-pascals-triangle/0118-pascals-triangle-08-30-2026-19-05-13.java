class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        for(int i = 2; i <= numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i - 1; j++){
                temp.add(list.get(i - 2).get(j) + list.get(i - 2).get(j - 1));
            }
            temp.add(1);
            list.add(temp);
        }

        return list;
    }
}