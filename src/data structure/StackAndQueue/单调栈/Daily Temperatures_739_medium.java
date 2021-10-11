//O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < temperatures.length;i++){
          while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
              int temp = stack.pop();
              res[temp] = i - temp;
          }
        stack.push(i);
          
      }
      return res;
    }
}