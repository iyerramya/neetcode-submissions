class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray = new int[nums.length];
        int prefixProduct = 1;
        prefixArray[0] = prefixProduct;
        for(int i=1; i<nums.length; i++) {
            prefixProduct = nums[i-1] * prefixProduct;
            prefixArray[i] = prefixProduct;
        }
        int[] suffixArray = new int[nums.length];
        int suffixProduct = 1;
        suffixArray[nums.length-1] = suffixProduct;
        for(int i=nums.length-2; i>=0; i--) {
            suffixProduct = nums[i+1] * suffixProduct;
            suffixArray[i] = suffixProduct;
        }
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            res[i] = prefixArray[i] * suffixArray[i];
        }
        return res;
    }
}  
