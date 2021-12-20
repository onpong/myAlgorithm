/**
 * O(N)
 * O(1)
 */
class Solution {
    public int minArray(int[] numbers) {
        int slow = 0;
        int fast = 1;
        while(fast < numbers.length){
            if(numbers[slow] > numbers[fast])
                return numbers[fast];
            slow++;
            fast++;
        }
        if(slow == numbers.length -1)
            return numbers[0];
        return -1;
    }
}

/**
 * 二分法
 * O(LOGN)
 * O(1)
 */
class Solution {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
