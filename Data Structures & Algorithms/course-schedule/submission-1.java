class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create a map indegree
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for(int i=0; i<numCourses;i++) {
            preMap.put(i, new ArrayList<>());
        }
        //add courses into preMap 
        for(int[] prerequisite : prerequisites) {
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        //dfs through all
        Set<Integer> visiting = new HashSet<>();
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i, preMap, visiting)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visiting) {
        if(preMap.get(course).isEmpty()) {
            return true;
        }
        if(visiting.contains(course)) {
            return false;
        }
        visiting.add(course);
        for(int c : preMap.get(course)) {
            if(!dfs(c,preMap,visiting)) {
                return false;
            }
        }
        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;

    }
}
