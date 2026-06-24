class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String newS = new String(temp);
            map.putIfAbsent(newS, new ArrayList<>());
            map.get(newS).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
