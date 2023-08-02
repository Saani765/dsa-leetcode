class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        f(0,nums,result);
        return result;
    }
    private void f(int index,int[] arr, List<List<Integer>> ans)
    {
        if(index==arr.length)
        {
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<arr.length;i++)
            {
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return; }
        for(int i=index;i<arr.length;i++)
            {
                swap(i,index,arr);
                f(index+1,arr,ans);
                swap(i,index,arr);
            }
        } 
    
    private void swap(int i,int j,int[] nums)
    {
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
}