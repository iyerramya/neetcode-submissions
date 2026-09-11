class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int i=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if( i < k) {
                minHeap.offer(entry);
            } else {
                minHeap.offer(entry);
                if(minHeap.size()>k) {
                    minHeap.poll();
                }
            }
            i++;
        }
        int[] res = new int[k];
        i =0;
        while(!minHeap.isEmpty()) {
            res[i++] = minHeap.poll().getKey();
        }
        return res;
    }
}
