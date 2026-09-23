class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> hasVisited = new HashSet<>();
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, hasVisited,preMap )) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, Set<Integer> hasVisited, Map<Integer, List<Integer>> preMap) {
        if(preMap.get(i).isEmpty()) {
            return true;
        }
        if(hasVisited.contains(i)) {
            return false;
        }
        hasVisited.add(i);
        for(int pre : preMap.get(i)) {
            if(!dfs(pre, hasVisited, preMap)) {
                return false;
            }
        }
        hasVisited.remove(i);
        preMap.put(i, new ArrayList<>());
        return true;
    }
}
