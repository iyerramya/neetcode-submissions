class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, max = 0, lastIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char letter = s.charAt(i);
            if(map.containsKey(letter)) {
                lastIndex = Math.max(lastIndex, map.get(letter) + 1);
            }
            len = i - lastIndex + 1;
            max = Math.max(len, max);
            map.put(letter, i);
        }
        return max;
    }
}
