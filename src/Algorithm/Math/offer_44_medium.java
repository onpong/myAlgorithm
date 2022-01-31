//O(logn)
//O(1)
class Solution {
    public int findNthDigit(int n) {
        int start = 1;//在当前digit的数位情况下，位数开始的地方，如digit为3则start为190
        int digit = 1;//表示数位，如1-9为1，10-99为2，100-999为3
        //找到当前n属于哪个范围，因为每个数位都有一个对应范围
        //比如digit为1对应1-9
        //digit为2对应10-189
        //while循环结束后能得到start以及digit的值
        //当前digit所处的范围有9 * Math.pow(10,digit - 1)个数字。
        while(!(n >= start && n < start + digit * 9 * Math.pow(10,digit - 1))){
            start = (int)(start + digit * 9 * Math.pow(10,digit - 1));
            digit++;
        }
        //n减去start之前的位数除以digit则表示在n之前一共有几个数
        //n减去start之前的位数取模digit则表示n处于当前数字的第几位
        int left = n - start + 1;
        int before = left / digit;
        int index = (int)(left % digit);
        //得到当前范围数字的开头，如digit为2则开头为10，注意begin和start一个表示数字开头，一个表示位数开头。
        int begin = (int)Math.pow(10,digit - 1);
        int res = (int)(begin + before - 1);//得到n所处的数字或者前一个数字（要看是否有余数）
        if(index == 0){//假若没有余数
            String temp = Integer.toString(res);
            char numbers = temp.charAt(temp.length() - 1);
            return numbers - '0';
        }else{//假若有余数
            res += 1;
            String temp = Integer.toString(res);
            char numbers = temp.charAt(index - 1);
            return numbers - '0';
        }

    }
}

//思路和我差不多，也是找范围求余确定位数。
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.表示在哪个数中
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.这个数中的第几位
    }
}
