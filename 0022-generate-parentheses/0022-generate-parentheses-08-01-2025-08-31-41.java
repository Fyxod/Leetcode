class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n*2, n, n, "", list);
        return list;
    }
    void helper(int n, int start, int end, String curr, List<String> list){
        if(n == 0){
            list.add(curr);
            return;
        }
        if(start == end){
            helper(n - 1, start - 1, end, curr + "(", list);
        }
        else if(start < end){
            if(start > 0)helper(n - 1, start - 1, end, curr + "(", list);
            helper(n - 1, start, end - 1, curr + ")", list);
        }
    }
}
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> list = new ArrayList<>();
//         helper(n, n*2, 0, 0, "", list);
//         return list;
//     }
//     void helper(int limit, int n, int start, int end, String curr, List<String> list){
//         if(n == 0){
//             list.add(curr);
//             return;
//         }
//         if(start == end){
//             helper(limit, n - 1, start + 1, end, curr + "(", list);
//         }
//         else if(start > end){
//             if(start < limit)helper(limit, n - 1, start + 1, end, curr + "(", list);
//             helper(limit, n - 1, start, end + 1, curr + ")", list);
//         }
//     }
// }