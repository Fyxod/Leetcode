class Solution {
    record Pair(int r, int c, StringBuilder sb){};
    String correct = "123450";
    int R = 2;
    int C = 3;
    Set<String> set;
    int DIR[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int INF = Integer.MAX_VALUE / 2;
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        int zr = -1;
        int zc = -1;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(board[i][j] == 0){
                    zr = i;
                    zc = j;
                }
                sb.append(board[i][j]);
            }
        }

        set = new HashSet<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(zr, zc, sb));
        set.add(sb.toString());

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                Pair p = q.poll();
                StringBuilder temp = p.sb;
                int r = p.r;
                int c = p.c;
                String str = temp.toString();
                if(str.equals(correct)) return steps;

                for(int dir[] : DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    int id = r * C + c;
                    int nid = nr * C + nc;
                    char a = str.charAt(id);
                    char b = str.charAt(nid);
                    StringBuilder next = new StringBuilder(str);
                    next.setCharAt(id, b);
                    next.setCharAt(nid, a);
                    if(!set.add(next.toString())) continue;
                    q.offer(new Pair(nr, nc, next));
                }
            }
            steps++;
        }

        return -1;
    }
    // int f(StringBuilder sb, int board[][], int r, int c){
    //     String str = sb.toString();
    //     System.out.println(str);
    //     if(str.equals(correct)) return 0;
    //     if(map.containsKey(str)) return map.get(str);
    //     map.put(str, INF);
    //     int min = INF;

    //     for(int dir[] : DIR){
    //         int nr = r + dir[0];
    //         int nc = c + dir[1];

    //         if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
    //         int id = r * C + c;
    //         int nid = nr * C + nc;
    //         char a = sb.charAt(id);
    //         char b = sb.charAt(nid);
    //         sb.setCharAt(id, b);
    //         sb.setCharAt(nid, a);
    //         min = Math.min(min, f(sb, board, nr, nc));
    //         sb.setCharAt(id, a);
    //         sb.setCharAt(nid, b);
    //     }
    //     map.put(str, 1 + min);
    //     return 1 + min;
    // }
}