//做法一：慢的要死。
class Solution {
    public String frequencySort(String s) {
        String res = "";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp))
                map.put(temp,map.get(temp) + 1);
            else{
                map.put(temp,1);
            }
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for(char key : map.keySet()){
            int value = map.get(key);
            if(buckets[value] == null)
                buckets[value] = new ArrayList();
            buckets[value].add(key);
        } 
        for(int i = buckets.length - 1;i > 0;i--){
            if(buckets[i] != null){
                for(int j = 0;j < buckets[i].size();j++){
                    int times = i;
                    while(times > 0){
                        String str = String.valueOf(buckets[i].get(j));
                        res += str;
                        times--;
                    }
                }
            }
        }
        return res;       
    }
}
//做法二
//就是把做法一的字符串相加方式换了，快了许多
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i < s.length();i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp))
                map.put(temp,map.get(temp) + 1);    
            else{
                map.put(temp,1);
            }
        }
        List<Character>[] buckets = new List[s.length() + 1];
        for(char key : map.keySet()){
            int value = map.get(key);
            if(buckets[value] == null)
                buckets[value] = new ArrayList();
            buckets[value].add(key);
        } 
        for(int i = buckets.length - 1;i > 0;i--){
            if(buckets[i] != null){
                for(int j = 0;j < buckets[i].size();j++){
                    int times = i;
                    while(times > 0){
                        sb.append(buckets[i].get(j));
                        times--;
                    }
                }
            }
        }
        return sb.toString();       
    }
}
//做法3
//用二维数组代替哈希表
class Solution {   
    public String frequencySort(String s) {
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();
        for (int i = 0; i < 128; i++) cnts[i][0] = i;
        for (char c : cs) cnts[c][1]++;
        Arrays.sort(cnts, (a, b)->{
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char)cnts[i][0];
            int k = cnts[i][1];
            while (k-- > 0) sb.append(c);
        }
        return sb.toString();
    }
}
