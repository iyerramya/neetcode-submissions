class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            if(map.containsKey(c)) {
                l = Math.max(map.get(c)+1,l);
            }
            max = Math.max(max, r-l+1);
            map.put(c, r);
        }
        return max;
    }
}
