/**
 * O（N）
 * O(N)
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /** 
        根据pushed数组不断入栈，直到碰见poped数组首元素
        如果pop数组首元素就等于栈顶元素则出栈
        否则继续入栈直到碰见pop首元素
        如果最后栈中元素为空，则成功
         */
         Stack<Integer> stack = new Stack<>();
         int pu = 0;
         int po = 0;
         while(pu < pushed.length){
             if(!stack.isEmpty() && stack.peek() == popped[po]){
                 stack.pop();
                 po++;
             }else{
                 stack.push(pushed[pu++]);
             }
         }
         //入栈全部完毕，接下来就看能不能全部弹出栈，能则true否则false
         while(po < popped.length){
             if(popped[po] == stack.peek()){
                 stack.pop();
                 po++;
             }else{
                 return false;
             }
         }
         return true;

    }
}
/**
 * 简化版
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

