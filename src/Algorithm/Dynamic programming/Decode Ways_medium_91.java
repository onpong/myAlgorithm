class Solution {
    public int numDecodings(String s) {
        int ppre = 1;
        int pre = 1;
        int cur = 1;
        if(s.charAt(0) == '0')
            return 0;
        if(s.length() == 1){
            return 1;
        }
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == '0' && (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3')){
                return 0;
            }else if(s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')){
                cur = ppre;
            }else if((s.charAt(i - 1) == '1' && s.charAt(i) != '0') || (s.charAt(i - 1) == '2' && 
            s.charAt(i) > '0' && s.charAt(i) <= '6')){
                cur = pre + ppre;
            }else{
                cur = pre;
            }
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}