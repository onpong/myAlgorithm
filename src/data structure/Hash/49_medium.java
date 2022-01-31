/**
 * 时间复杂度：排序的话算作 O（K log（K））O（Klog（K））,最外层的 for 循环，所以就是 O（n K log（K））O（nKlog（K））。
空间复杂度：O（NK）O（NK），用来存储结果。
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        将字符串进行排序存储在哈希表的键中
         */
         Map<String,List<String>> map = new HashMap<>();
         for(int i = 0; i < strs.length;i++){
             String s = sortS(strs[i]);
             if(map.containsKey(s)){
                 map.get(s).add(strs[i]);
             }else{
                 List<String> list = new ArrayList<>();
                 list.add(strs[i]);
                 map.put(s,list);
             }
         }
        List<List<String>> res = new ArrayList<>();
        Set keyset = map.keySet();
        for(Object temp : keyset){
            res.add(map.get((String)temp));
        }
        return res;
    }
    public String sortS(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < array.length;i++){
            sb.append(array[i]);
        }
        return sb.toString();
    }
}