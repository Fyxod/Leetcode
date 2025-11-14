class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        int n = graph.length;
        boolean vis[] = new boolean[n];


        for(int i = 0; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);

                while(!q.isEmpty()){
                    int curr = q.poll();
                    Set<Integer> main = A;
                    Set<Integer> other = B;
                    if(A.contains(curr)){
                        main = A;
                        other = B;
                    }
                    else if(B.contains(curr)){
                        main = B;
                        other = A;
                    }
                    else{
                        for(int a : graph[curr]){
                            if(A.contains(a)){
                                main = B;
                                other = A;
                                break;
                            }
                            else if(B.contains(a)){
                                main = A;
                                other = B;
                                break;
                            }
                        }
                    }
                    main.add(curr);
                    for(int a : graph[curr]){
                        if(main.contains(a)) return false;
                        if(other.add(a) && !vis[a]) q.add(a);
                    }
                }
            }
        }
        return true;
    }
}