/**
 * 方法1：队列
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Queue<String> queue = new LinkedList<>();
        int index = 1;
        String temp = map[digits.charAt(0) - '2'];
        for(int i = 0;i < temp.length();i++){
            queue.add("" + temp.charAt(i));
        }
        while(index < digits.length()){
            int size = queue.size();
            String s = map[digits.charAt(index++) - '2'];
            while(size-- != 0){
                String ss = queue.poll();
                for(int i = 0;i < s.length();i++){
                    queue.add(ss + s.charAt(i));
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
       
    }
}
/**
 * 方法2：回溯
 */