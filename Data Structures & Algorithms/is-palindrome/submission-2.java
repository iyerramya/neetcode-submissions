class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // 1. Move the left pointer until it hits an alphanumeric character
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // 2. Move the right pointer until it hits an alphanumeric character
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // 3. Compare lowercase versions
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }
        
        return true;
    }
}