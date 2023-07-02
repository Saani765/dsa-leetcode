class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int minlen=Integer.MAX_VALUE;
        int sum=0;
        while(j<nums.length)
        {   
            sum+=nums[j];
            if(sum>=target) 
            {
                while(sum>=target)
                {
                    minlen=Math.min(minlen,j-i+1);
                    sum=sum-nums[i];
                    i++;
                }
            }
            j++;

        }
        return (minlen==Integer.MAX_VALUE) ? 0:    minlen;
    }
}
