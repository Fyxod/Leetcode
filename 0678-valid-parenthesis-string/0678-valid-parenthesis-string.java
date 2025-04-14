// class Solution {
//     public boolean checkValidString(String s) {

//     }
// }

// trying backtracking
class Solution {
    public boolean checkValidString(String s) {
        int length = s.length();
        if(length == 0) return true;
        if(length == 1){
            if(s.charAt(0) == ')' || s.charAt(0) == '(') return false;
            else return true;
        }
        return helper(s, 0, 0);
    }

Map<String, Boolean> memo = new HashMap<>();

boolean helper(String s, int index, int count) {
    String key = index + "," + count;
    if (memo.containsKey(key)) return memo.get(key);

    if (count < 0) return false;
    if (index == s.length()) return count == 0;

    boolean result;
    char c = s.charAt(index);
    if (c == '(') {
        result = helper(s, index + 1, count + 1);
    } else if (c == ')') {
        result = helper(s, index + 1, count - 1);
    } else {
        result = helper(s, index + 1, count + 1) ||
                 helper(s, index + 1, count - 1) ||
                 helper(s, index + 1, count);
    }

    memo.put(key, result);
    return result;
}
}

// my best try
// cant figure out this one
// class Solution {
//     public boolean checkValidString(String s) {
//         int count = 0;
//         int ast = 0;

//         for(char a : s.toCharArray()){
//             if(a == '(') count++;
//             if(a == ')') count--;
//             if(a == '*') ast++;

//             if(count < 0){
//                 if(count + ast >= 0){
//                     count = 0;
//                     ast = ast + count;
//                 }
//                 else {
//                     return false;
//                 }
//             }
//         }
//         System.out.println(count);
//         System.out.println(ast);
//         if(count < 0) return false;
//         if(count > 0 && count - ast > 0) return false;
//         return true;
//     }
// }