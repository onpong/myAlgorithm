//做法一：
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if(isAllDigit(expression,0,expression.length() - 1)){
            String s = "";
            for(int i = 0;i <= expression.length() - 1;i++){
                s += expression.charAt(i);
            }
            Integer a = Integer.parseInt(s);
            res.add(a);
            return res;
        }
        for(int i = 0;i < expression.length();i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                continue;
            char operator = expression.charAt(i);
            List<Integer> leftAns = divide(expression,0,i - 1);
            List<Integer> rightAns = divide(expression,i + 1,expression.length() - 1);
            List<Integer> ans = help(leftAns,rightAns,operator);
            for(int j = 0;j < ans.size();j++){
                    res.add(ans.get(j));
            }
        }
        return res;
    }
    public List<Integer> divide(String expression,int start,int stop){
        List<Integer> ans = new ArrayList<>();
        //判断若全是数字，则返回数字。
        if(isAllDigit(expression,start,stop)){
            String s = "";
            for(int i = start;i <= stop;i++){
                s += expression.charAt(i);
            }
            Integer a = Integer.parseInt(s);
            ans.add(a);
            return ans;
        }
        for(int i = start;i <= stop;i++){
            List<Integer> temp = new ArrayList<>();
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                continue;
            char operator = expression.charAt(i);
            List<Integer> leftAns = divide(expression,start,i - 1);
            List<Integer> rightAns = divide(expression,i + 1,stop);
            temp = help(leftAns,rightAns,operator);
            for(int j = 0;j < temp.size();j++){
                    ans.add(temp.get(j));
            }
        }
        return ans;

    }
    public List<Integer> help(List<Integer> leftAns,List<Integer> rightAns,char operator){
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < leftAns.size();i++){
            int left = leftAns.get(i);
            for(int j = 0;j < rightAns.size();j++){
                int right = rightAns.get(j);
                if(operator == '+'){
                    ans.add(left + right);
                }else if(operator == '-'){
                    ans.add(left - right);
                }else{
                    ans.add(left * right);
                }
            }
        }
        return ans;

    }
    public boolean isAllDigit(String expression,int start,int stop){
        for(int i = start;i <= stop;i++){
            if(!(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }
}
class Solution{
//做法二：
public List<Integer> diffWaysToCompute(String input) {
    if (input.length() == 0) {
        return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    int num = 0;
    //考虑是全数字的情况
    int index = 0;
    while (index < input.length() && !isOperation(input.charAt(index))) {
        num = num * 10 + input.charAt(index) - '0';
        index++;
    }
    //将全数字的情况直接返回
    if (index == input.length()) {
        result.add(num);
        return result;
    }
    
    for (int i = 0; i < input.length(); i++) {
        //通过运算符将字符串分成两部分
        if (isOperation(input.charAt(i))) {
            List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
            List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
            //将两个结果依次运算
            for (int j = 0; j < result1.size(); j++) {
                for (int k = 0; k < result2.size(); k++) {
                    char op = input.charAt(i);
                    result.add(caculate(result1.get(j), op, result2.get(k)));
                }
            }
        }
    }
    return result;
}

private int caculate(int num1, char c, int num2) {
    switch (c) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
    }
    return -1;
}

private boolean isOperation(char c) {
    return c == '+' || c == '-' || c == '*';
}
}

//做法三，在做法二的基础上加了个hashMap，使用memoization 技术
//添加一个 map
class Solution{
HashMap<String,List<Integer>> map = new HashMap<>();
public List<Integer> diffWaysToCompute(String input) {
    if (input.length() == 0) {
        return new ArrayList<>();
    }
    //如果已经有当前解了，直接返回
    if(map.containsKey(input)){
        return map.get(input);
    }
    List<Integer> result = new ArrayList<>();
    int num = 0;
    int index = 0;
    while (index < input.length() && !isOperation(input.charAt(index))) {
        num = num * 10 + input.charAt(index) - '0';
        index++;
    }
    if (index == input.length()) {
        result.add(num);
        //存到 map
        map.put(input, result);
        return result;
    }
    for (int i = 0; i < input.length(); i++) {
        if (isOperation(input.charAt(i))) {
            List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
            List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
            for (int j = 0; j < result1.size(); j++) {
                for (int k = 0; k < result2.size(); k++) {
                    char op = input.charAt(i);
                    result.add(caculate(result1.get(j), op, result2.get(k)));
                }
            }
        }
    }
     //存到 map
    map.put(input, result);
    return result;
}

private int caculate(int num1, char c, int num2) {
    switch (c) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
    }
    return -1;
}

private boolean isOperation(char c) {
    return c == '+' || c == '-' || c == '*';
}
}
//做法四
class Solution{
public List<Integer> diffWaysToCompute(String input) {
    List<Integer> numList = new ArrayList<>();
    List<Character> opList = new ArrayList<>();
    char[] array = input.toCharArray();
    int num = 0;
    for (int i = 0; i < array.length; i++) {
        if (isOperation(array[i])) {
            numList.add(num);
            num = 0;
            opList.add(array[i]);
            continue;
        }
        num = num * 10 + array[i] - '0';
    }
    numList.add(num);
    int N = numList.size(); // 数字的个数

    // 一个数字
    ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
    for (int i = 0; i < N; i++) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(numList.get(i));
        dp[i][i] = result;
    }
    // 2 个数字到 N 个数字
    for (int n = 2; n <= N; n++) {
        // 开始下标
        for (int i = 0; i < N; i++) {
            // 结束下标
            int j = i + n - 1;
            if (j >= N) {
                break;
            }
            ArrayList<Integer> result = new ArrayList<>();
            // 分成 i ~ s 和 s+1 ~ j 两部分
            for (int s = i; s < j; s++) {
                ArrayList<Integer> result1 = dp[i][s];
                ArrayList<Integer> result2 = dp[s + 1][j];
                for (int x = 0; x < result1.size(); x++) {
                    for (int y = 0; y < result2.size(); y++) {
                        // 第 s 个数字下标对应是第 s 个运算符
                        char op = opList.get(s);
                        result.add(caculate(result1.get(x), op, result2.get(y)));
                    }
                }
            }
            dp[i][j] = result;

        }
    }
    return dp[0][N-1];
}

private int caculate(int num1, char c, int num2) {
    switch (c) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
    }
    return -1;
}

private boolean isOperation(char c) {
    return c == '+' || c == '-' || c == '*';
}
}
