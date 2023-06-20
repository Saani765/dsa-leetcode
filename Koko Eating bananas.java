class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int banana :piles)
        {
            right=Math.max(right,banana);
        }
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public boolean canEatInTime(int piles[], int k, int h){
        long hours = 0;
        for(long pile : piles){
            long time = pile / k;
            hours += time;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}
