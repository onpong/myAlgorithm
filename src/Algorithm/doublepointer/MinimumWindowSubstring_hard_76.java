class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        int[] have = new int[128];
        int[] need = new int[128];
        for(int i = 0;i < t.length();i++)
            need[t.charAt(i)]++;
        int slow = 0,fast = 0,start = 0,min = s.length() + 1;
        int count = 0;
        for(;fast < s.length();){
            char ftemp = s.charAt(fast);
            if(need[ftemp] == 0){
                fast++;
                continue;
            }
            if(have[ftemp] < need[ftemp]){
                count++;
            }
            have[ftemp]++;
            while(count == t.length()){
                char stemp = s.charAt(slow);
                if(need[stemp] == 0){
                    slow++;
                    continue;
                }
                if(have[stemp] == need[stemp]){
                    if(fast - slow < min){
                        min = fast -slow;
                        start =slow;
                    }
                    count--;
                    
                }
                have[stemp]--;
                slow++;
            }
            fast++;
        }
         if (min == s.length() + 1) {
            return "";
        }
       return s.substring(start, start + min + 1);
    }
}