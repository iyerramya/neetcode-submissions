class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;

        int t = 0;
        int b = m;
        int row = -1;
        while(t<=b) {
            int mid = (t+b)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][n]) {
                row = mid;
                break;
            } else if (target > matrix[mid][n]) {
                t = mid+1;
            } else if(target < matrix[mid][0]) {
                b = mid-1;
            }
        }
        if(row == -1) {
            return false;
        }
        int l = 0;
        int r = n;
        while(l<=r) {
            int mid = (l+r)/2;
            if(target == matrix[row][mid]) {
                return true;
            } else if(target > matrix[row][mid]) {
                l = mid+1;
            } else if(target < matrix[row][mid]) {
                r = mid-1;
            }
        }
        return false;
    }
}
