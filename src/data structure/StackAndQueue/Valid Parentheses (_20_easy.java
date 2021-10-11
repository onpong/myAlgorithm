//stack.push('?');的作用是防止类似s = "(()))"的情况。
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.pop() != map.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.peek() == '?';
    }
}