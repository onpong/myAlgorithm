//O(N)
//O(1)
class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        HashMap<Character,Integer> hash = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char key = s.charAt(i);
            if(!hash.containsKey(key)){
                hash.put(key,1);
            }else{
                int value = hash.get(key);
                hash.put(key,++value);
            }
        }
        boolean isOdd = false;
        Set set = hash.keySet();
        for(Object o : set){
            Character temp = (Character)o;
            int value = hash.get(temp);
            if(value % 2 == 0){
                res += value;
            }else{
                isOdd = true;
                res += value - 1;
            }
        }
        return isOdd ? res + 1 : res;
    }
}