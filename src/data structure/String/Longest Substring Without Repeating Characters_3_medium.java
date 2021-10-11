/**
 * 方法1:暴力法。
 * O(N2)
 * O(N)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;
        int res= 0;
        ArrayList<Character> list = new ArrayList<>();;
        for(int i = 0;i < s.length();i++){
            res = Math.max(res,list.size());
            list = new ArrayList<>();
            if(res >= s.length() - i)
                break;
            for(int j = i;j < s.length();j++){
                char temp = s.charAt(j);
                if(!list.contains(temp)){
                    list.add(temp);
                }else{
                    i = i + list.indexOf(temp);//找到重复的元素在s中的位置
                    break;
                }
            }

        }
        return res;
    }
}
/**
 * 方法二：滑动窗口
 * O(N)
 * O(N)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}

