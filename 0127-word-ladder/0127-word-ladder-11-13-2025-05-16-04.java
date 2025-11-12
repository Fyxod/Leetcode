class Solution {
    class QData{
        int ind;
        int seqNo;

        QData(int ind, int seqNo){
            this.ind = ind;
            this.seqNo = seqNo;
        }
    }
    class MData{
        int ind;
        boolean vis;

        MData(int ind){
            this.ind = ind;
            this.vis = false;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, MData> map = new HashMap<>();

        Queue<QData> q = new ArrayDeque<>();
        wordList.add(beginWord);
        for(int i = 0; i < wordList.size(); i++) map.put(wordList.get(i), new MData(i));
        q.offer(new QData(wordList.size() - 1, 1));
        map.get(beginWord).vis = true;

        if(!map.containsKey(endWord)) return 0;

        while(!q.isEmpty()){
            QData curr = q.poll();
            StringBuilder sb = new StringBuilder(wordList.get(curr.ind));
            for(int i = 0; i < sb.length(); i++){
                char save = sb.charAt(i);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    sb.setCharAt(i, ch);
                    String temp = sb.toString();
                    if(map.containsKey(temp) && !map.get(temp).vis){
                        if(temp.equals(endWord)) return curr.seqNo + 1;
                        map.get(temp).vis = true;
                        q.offer(new QData(map.get(temp).ind, curr.seqNo + 1));
                    }
                }
                sb.setCharAt(i, save);
            }
        }
        return 0;
    }
}