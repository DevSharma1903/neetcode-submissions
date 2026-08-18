class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int len = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true) return len;

            for(int i=0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String newW = new String(arr);

                    if(set.contains(newW)){
                        set.remove(newW);
                        q.offer(new Pair(newW, len+1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair{
    String first;
    int second;

    public Pair(String f, int s){
        this.first = f;
        this.second = s;
    }
}
