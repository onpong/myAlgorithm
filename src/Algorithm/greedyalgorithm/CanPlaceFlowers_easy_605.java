class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       for(int i = 0;i < flowerbed.length && n > 0;i += 2){
           if(flowerbed[i] == 0){
               if(i + 1 ==flowerbed.length || flowerbed[i + 1] == 0){
                   n--;
                   continue;
               }else{
                   i++;
               }
           }
       }
       if(n == 0){
           return true;
       }
       return false;
    }
}