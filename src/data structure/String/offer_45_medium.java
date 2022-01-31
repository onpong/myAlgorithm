/**
 * 快排法
 * O(Nlogn)
 * O(N)
 */
class Solution {
    public String minNumber(int[] nums) {
        String[] strs= new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }
    public void quickSort(String[] strs,int l,int r){
        if(l >= r)
            return;
        int i = l;
        int j = r;
        String temp = strs[l];
        while(i < j){
            while(i < j && (strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0)
                j--;
            while(i < j && (strs[i] + strs[l]).compareTo(strs[l] + strs[i]) < 0)
                i++;
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[l];
        strs[l] = temp;
        quickSort(strs,l,i - 1);
        quickSort(strs,i + 1,r);
    }
}
/**
 * 内置函数
 * O(Nlogn)
 * O(N)
 */
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1,String s2){
                if((s1 + s2).compareTo(s2 + s1) < 0)
                    return -1;
                else if((s1 + s2).compareTo(s2 + s1) > 0)
                    return 1;
                else
                    return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}

