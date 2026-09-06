class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>();
        for(String i : wordList){
            set.add(i);
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().f;
            int len = q.peek().l;
            q.remove();

            if(word.equals(endWord)) return len;

            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<= 'z'; ch++){
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
    String f;
    int l;

    public Pair(String f, int l){
        this.f = f;
        this.l = l;
    }
}
