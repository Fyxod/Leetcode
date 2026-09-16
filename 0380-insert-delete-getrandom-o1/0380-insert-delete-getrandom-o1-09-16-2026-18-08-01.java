class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();    
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int ind = map.get(val);

            int lastElement = list.get(list.size() - 1);
            list.set(ind, lastElement);

            map.put(lastElement, ind);
            map.remove(val);

            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int ind = random.nextInt(list.size());
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */