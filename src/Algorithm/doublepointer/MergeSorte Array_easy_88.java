//做法一：利用新创建的空间。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArray = new int[nums1.length];
        int pointerOfNums1 = 0;
        int pointerOfNums2 = 0;
        int k = 0;
        while(pointerOfNums1 < m && pointerOfNums2 < n){
            if(nums1[pointerOfNums1] <= nums2[pointerOfNums2]){
                tempArray[k] = nums1[pointerOfNums1];
                pointerOfNums1++;
                k++;
            }else{
                tempArray[k] = nums2[pointerOfNums2];
                pointerOfNums2++;
                k++;
            }
        }
        if(pointerOfNums1 < m){
            while(pointerOfNums1 < m){
                tempArray[k] = nums1[pointerOfNums1];
                pointerOfNums1++;
                k++;
            }
        }
        if(pointerOfNums2 < n){
            while(pointerOfNums2 < n){
                tempArray[k] = nums2[pointerOfNums2];
                pointerOfNums2++;
                k++;
            }
        }
        for(int i = 0;i < nums1.length;i++)
            nums1[i] = tempArray[i];
    }
}

//做法二：
//因为这两个数组已经排好序，我们可以把两个指针分别放在两个数组的末尾，
//即 nums1 的 m m 1 位和 nums2 的 n n 1 位。
//每次将较大的那个数字复制到 nums1 的后边，然后向前移动一位。
//因为我们也要定位 nums1 的末尾，所以我们还需要第三个指针，以便复制。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int pos = m + n - 1;
        while(pointer1 >= 0 && pointer2 >= 0){
            if(nums1[pointer1] >= nums2[pointer2]){
                nums1[pos] = nums1[pointer1];
                pointer1--;
                pos--;
            }else{
                nums1[pos] = nums2[pointer2];
                pointer2--;
                pos--;
            }      
        }
        while(pointer2 >= 0){
            nums1[pos] = nums2[pointer2];
                pointer2--;
                pos--;
        }
    }
}