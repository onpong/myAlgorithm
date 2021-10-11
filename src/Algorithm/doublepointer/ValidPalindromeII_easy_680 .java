//做法一：虽然时间复杂度低但代码可读性不高
class Solution {
    public boolean validPalindrome(String s) {
        int count = 1;
        int left = 0;
        int right = s.length() - 1;
        int li = 0;
        int ri = 0;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                li = left;
                ri = right;
                left++;
                while(left < right){
                    if(s.charAt(left) == s.charAt(right)){
                        left++;
                        right--;
                    }else{
                        break;
                    }
                }
                if(left >= right)
                    return true;
                else{
                    left = li;
                    right = ri;
                    right--;
                     while(left < right){
                    if(s.charAt(left) == s.charAt(right)){
                        left++;
                        right--;
                    }else{
                        return false;
                    }
                }
                }
            }
        }
        return true;
    }
}

//做法二
class Solution{
public boolean validPalindrome(String s) {
        int front = 0;
        int end = s.length() - 1;
        // < 符号，中间一个字符不影响回文与否
        while (front < end) {
            if (s.charAt(front) != s.charAt(end)) {
                return validPalindromeHelper(s, front + 1, end) || validPalindromeHelper(s, front, end - 1);
            }
            front++;
            end--;
        }
        return true;
    }

    public boolean validPalindromeHelper(String s, int front, int end) {
        while (front < end) {
            if (s.charAt(front) != s.charAt(end)) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }
}