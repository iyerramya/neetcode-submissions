class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int length = 0;
            if(!set.contains(nums[i]-1)) {
                int j = nums[i];
                while(set.contains(j)) {
                    length += 1;
                    j++;
                }
            }
            max = Math.max(length, max);
        }
        return max;
    }
}

