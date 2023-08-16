class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int j=0;
        while(j<nums.length)
        {
            if(dq.size()==0) dq.add(nums[j]);
            else
            {
                while(dq.size()!=0 && nums[j]>dq.peekLast()) dq.pollLast();
                dq.add(nums[j]);
            }
            if(j-i+1==k)
            {
                ans[i]=dq.peek();
                if(nums[i]==dq.peek()) dq.pollFirst();
                i++;

            }
            j++;
        }
        return ans;
    }
}