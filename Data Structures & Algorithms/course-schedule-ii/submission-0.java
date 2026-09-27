class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /**
        indegree
        0 2 -> 1 -> 0
        1 1 ->  0
        2 1 -> 0
        3 1

        adj
        0 [3]
        1 [0]
        2 [0]
        3 [1,2]

        q = [3]
        [1, 2]
        [2, 0]

        list = [3, 1, 2, 0]
         */
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int currIndex = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            result[currIndex++] = node;
            for(int nei : adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if(currIndex != numCourses) {
            return new int[0];
        }

        return result;
    }
}