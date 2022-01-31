/*
O(N)
O(N)
 */
class Solution {
    public String decodeString(String s) {
        /**
        栈stack存储其他字符
        当碰到右括号时，从stack中弹出字符直到弹出数字，然后将这些字符重复数字的次数
        再压入栈
        s遍历结束为止
         */
         Stack<Character> stack = new Stack<>();
         char[] array = s.toCharArray();
         for(int i = 0; i < array.length;i++){
            if(array[i] == ']'){
                StringBuilder temp = new StringBuilder();
                //获取要重复的字符串
                while(stack.peek() != '['){
                    temp.append(stack.pop());
                }
                stack.pop();//重复后弹出左括号
                temp.reverse();
                String num = "";
                //获取要重复的次数
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    num = stack.pop() + num;
                }
                int count = Integer.parseInt(num);
                //进行重复
                while(count-- != 0){
                    for(int j = 0; j < temp.length();j++){
                        stack.push(temp.charAt(j));
                    }
                }
            }else{
                stack.push(array[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}