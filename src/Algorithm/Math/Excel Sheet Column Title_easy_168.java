//做法一：
//注意看当余数为0的时候怎么处理的。向商借个一。
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            Integer remainder = columnNumber % 26;
            if(remainder == 0){
                remainder = 26;
                columnNumber -= 26;
            }
            columnNumber = columnNumber / 26;
            char temp = (char)('A' + remainder - 1);
            ans.append(temp);
        
        }
        return ans.reverse().toString();
    }
}
//做法二：整体偏移
class Solution {
    public String convertToTitle(int cn) {
        StringBuilder sb = new StringBuilder();
        while (cn > 0) {
            cn--;
            sb.append((char)(cn % 26 + 'A'));
            cn /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}

