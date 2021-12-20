/**
 * O(N)
 * O(N)
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        while(i < n){
            char temp = sb.charAt(i++);
            sb.append(temp);
        }
        return sb.toString().substring(n,sb.length());
    }
}