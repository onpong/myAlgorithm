//时间复杂度O(N)
//空间复杂度O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> hash = new HashMap<>();
        HashMap<Character,Integer> hash1 = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(hash.containsKey(temp)){
                int times = hash.get(temp);
                times++;
                hash.put(temp,times);
            }else{
                hash.put(temp,1);
            }
        }
        for(int i = 0;i < t.length();i++){
            char temp = t.charAt(i);
            if(hash1.containsKey(temp)){
                int times = hash1.get(temp);
                times++;
                hash1.put(temp,times);
            }else{
                hash1.put(temp,1);
            }
        }
        Set set = hash.keySet();
        for(Object c : set){
            Character cc = (Character)c;
            int times = hash.get(cc);
            if((!hash1.containsKey(cc)) || hash1.get(cc) != times){
                return false;
            }
        }
        return true;

    }
}
//方法2
//O(N)
//O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}

