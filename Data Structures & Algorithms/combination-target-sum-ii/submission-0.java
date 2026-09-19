class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target,combination, res);
        return res;
    }

private void dfs(int[] nums, int i, int sum, int target, List<Integer> combination, List<List<Integer>> res) {
    // 1. Check for success FIRST
    if (sum == target) {
        res.add(new ArrayList<>(combination));
        return;
    }
    // Then check for out of bounds or exceeding the target
    if (i >= nums.length || sum > target) {
        return;
    }

    // --- INCLUDE BRANCH ---
    combination.add(nums[i]);
    // You can just pass sum + nums[i] directly instead of modifying the sum variable!
    dfs(nums, i + 1, sum + nums[i], target, combination, res);
    
    // --- BACKTRACK ---
    // Remove the element BEFORE exploring the exclude branch
    combination.remove(combination.size() - 1);

    // --- EXCLUDE BRANCH ---
    // Skip all identical elements to prevent duplicate combinations
    while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        i++;
    }
    // Proceed to the next unique element
    dfs(nums, i + 1, sum, target, combination, res);
}}
