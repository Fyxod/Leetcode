class Solution {
    int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public int openLock(String[] deadends, String target) {
        boolean vis[] = new boolean[10000];
        vis[0] = false;

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        for(String a : deadends) {
            if(a.equals("0000")) return -1;
            vis[Integer.parseInt(a)] = true;
        }

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String s = q.poll();

                if(s.equals(target)) return steps;


                for(int i = 0; i < 4; i++){
                    int digit = s.charAt(i) - '0';
                    int plus, minus;
                    if(digit == 9) plus = 0;
                    else plus = digit + 1;
                    if(digit == 0) minus = 9;
                    else minus = digit - 1;
                    char[] arr = s.toCharArray();
                    arr[i] = (char)(plus + '0');
                    String plusS = new String(arr);
                    arr[i] = (char)(minus + '0');
                    String minusS = new String(arr);
                    int plusI = Integer.parseInt(plusS);
                    int minusI = Integer.parseInt(minusS);
                    if(!vis[plusI]){
                        vis[plusI] = true;
                        q.offer(plusS);
                    }
                    if(!vis[minusI]){
                        vis[minusI] = true;
                        q.offer(minusS);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}