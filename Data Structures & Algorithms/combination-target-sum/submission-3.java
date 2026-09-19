class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(nums, 0, 0, target,combination, res);
        return res;
    }

    private void dfs(int[] nums, int i, int sum, int target, List<Integer> combination, List<List<Integer>> res) {
        if(i >= nums.length || sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }
        sum += nums[i];
        combination.add(nums[i]);
        dfs(nums, i, sum, target, combination, res);
        sum -= nums[i];
        combination.remove(combination.size() - 1);
        dfs(nums, i+1, sum, target, combination, res);

    }
}
