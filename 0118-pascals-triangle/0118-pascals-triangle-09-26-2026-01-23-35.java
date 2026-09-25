class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));

        for(int i = 1; i < numRows; i++){
            List<Integer> last = list.get(list.size() - 1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int cnt = i + 1;
            for(int j = 1; j < i; j++){
                temp.add(last.get(j) + last.get(j - 1));
            }
            temp.add(1);
            list.add(temp);
        }

        return list;
    }
}