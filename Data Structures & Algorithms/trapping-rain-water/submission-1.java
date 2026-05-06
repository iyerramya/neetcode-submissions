class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int l = 0;
        while (l < height.length && height[l] == 0) {
            l++;
        }
        while (l < height.length) {
            int r = l + 1;
            int maxIdx = r;
            while (r < height.length && height[r] < height[l]) {
                if (r < height.length && height[r] >= height[maxIdx]) maxIdx = r;
                r++;
            }
            if (r < height.length && height[r] >= height[l]) {
                for (int i = l + 1; i < r; i++) {
                    sum += (height[l] - height[i]);
                }
                l = r;
            } else if (maxIdx < height.length) {
                for (int i = l + 1; i < maxIdx; i++) {
                    sum += (height[maxIdx] - height[i]);
                }
                l = maxIdx;
            } else {
                break;
            }

        }
        return sum;
        }
    }

