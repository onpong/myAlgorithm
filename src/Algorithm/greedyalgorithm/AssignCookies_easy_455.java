////做法一：实际上和做法二相同
//import java.util.Arrays;
//class Solution {
//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int sign=0;
//        int ans=0;
//        if(s.length==0){
//            return 0;
//        }
//        for(int i=0;i<g.length;i++){
//            for(int j=sign;j<s.length;j++){
//                if(s[j]>=g[i]){
//                    s[j]=0;
//                    sign=j+1;
//                    ans++;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }
//}
////做法二
//import java.util.Arrays;
//class Solution {
//    public int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int ans=0;
//        int i=0;
//        int j=0;
//        if(s.length==0){
//            return 0;
//        }
//        for(;i<g.length&&j<s.length;){
//            if(s[j]>=g[i]){
//                ans++;
//                i++;
//                j++;
//            }else{
//                j++;
//            }
//        }
//        return ans;
//    }
//}