class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
            String str = list2[i];
            if(map.containsKey(str)){
                int sum = map.get(str) + i;
                if(sum == min) list.add(str);
                else if(sum < min){
                    min = sum;
                    list.clear();
                    list.add(str);
                }
            }
        }

        return list.toArray(new String[0]);
    }
}