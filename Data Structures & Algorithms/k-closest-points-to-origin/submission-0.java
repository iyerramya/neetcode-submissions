class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
            distance(b[0],b[1]) - distance(a[0],a[1])
        );
        for(int[] point : points) {
            pq.offer(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            res[i][0] = curr[0]; 
            res[i][1] = curr[1]; 
            i++;
        }
        return res;
    }

    private int distance(int x, int y) {
        return (x*x)+(y*y);
    }
}
