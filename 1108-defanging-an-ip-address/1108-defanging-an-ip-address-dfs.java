class Solution {
    public String defangIPaddr(String address) {
        //different manual approach
        StringBuilder res = new StringBuilder();
        for(char c:address.toCharArray()){
            res.append((c == '.')? "[.]": c);
        }
        return res.toString();
    }
}