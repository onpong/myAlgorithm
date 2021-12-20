/**
 * O(N)
 * O(N)
 */
class Solution {
    public String reverseWords(String s) {
        s = s.strip();
        StringBuilder sb = new StringBuilder();
        int left = s.length() - 1;
        int right = left;
        while(left >= 0){
            while(left >= 0 && s.charAt(left) != ' '){
                left--;
            }
            sb.append(s.substring(left + 1,right + 1) + " ");
            while(left >= 0 && s.charAt(left) == ' '){
                left--;
            }
            right = left;
        }
        return sb.toString().strip();
    }
}