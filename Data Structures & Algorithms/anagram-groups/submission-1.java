class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++) {
            int[] chars = new int[26];
            for(int j=0; j<strs[i].length(); j++) {
                char currentChar = strs[i].charAt(j);
                chars[currentChar-'a']++;
            }
            String key = Arrays.toString(chars); 
            // if(!map.containsKey(key)) {
            //     map.put(key, new ArrayList<>());
            // }
            // map.get(key).add(strs[i]);
           map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
