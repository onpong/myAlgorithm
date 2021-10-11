//将每一处可以进行划分的位置与上一处可以进行划分的位置之间的字符串进保存到breakDict。，
//对s进行遍历，如果s.chatAt(i)不属于wordDict，那么就从breakDict中依次取出字符串进行拼接。再判断此时是否属于wordDict，如果属于，则加入breakDict。

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean res = false;
        String str = "";
        ArrayList<String> breakDict= new ArrayList<>();
        for(int i = 0 ;i < s.length();i++){
            res = false;
            str += s.charAt(i);
            if(isBelong(str,wordDict)){//s.chatAt(i)是否包含于wordDict，
                breakDict.add(str);
                str = "";
                res = true;
                continue;
            }
            String temp = str;
            for(int j = breakDict.size() - 1;j >= 0;j--){//依次取出breakDict中的元素进行拼接，看是否包含于wordDict。
                str = breakDict.get(j) + str;
                if(isBelong(str,wordDict)){
                    breakDict.add(temp);
                    str = "";
                    res = true;
                    break;
                }
            }
            if(str.length() > 0){
                str = temp;
            }
            

        }

       return res;
    }
    public boolean isBelong(String s,List<String> wordDict){//辅助函数，用于判断当前字符串是否包含于WordDict
        for(int i = 0 ;i < wordDict.size();i++){
            if(s.equals(wordDict.get(i)))
                return true;
        }
        return false;
    }
}



//做法2，每个位置是否能切分依赖于上一个位置
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1;i <= s.length();i++){
            for(int j = 0;j < wordDict.size();j++){
                String temp = wordDict.get(j);
                if(i >= temp.length() && s.substring(i - temp.length(),i).equals(temp)){
                    dp[i] = dp[i - temp.length()] || dp[i];//用例子s = "dogs"  wordDict["dog","s","gs"],跟踪一下就明白了。
                }
            }
        }
        return dp[s.length()];
    }
   
}

//做法三
//class Solution {
    /*
        动态规划算法，dp[i]表示s前i个字符能否拆分
        转移方程：dp[j] = dp[i] && check(s[i+1, j]);
        check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
        其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
        这个举个例子就很容易理解。
        假如wordDict=["apple", "pen", "code"],s = "applepencode";
        dp[8] = dp[5] + check("pen")
        翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
        （注意：i的顺序是从j-1 -> 0哦~
    */

    public HashMap<String, Boolean> hash = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        
        //方便check，构建一个哈希表
        for(String word : wordDict){
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for(int j = 1; j <= s.length(); j++){
            for(int i = j-1; i >= 0; i--){
                dp[j] = dp[i] && check(s.substring(i, j));//
                if(dp[j])   break;
            }
        }

        return dp[s.length()];
    }

    public boolean check(String s){
        return hash.getOrDefault(s, false);//如果有s则返回对应的值，否则默认返回false
    }
}
