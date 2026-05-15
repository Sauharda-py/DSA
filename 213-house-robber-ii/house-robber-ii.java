class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        
        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i] = nums[i];
        }
        for(int j=0;j<arr2.length;j++)
        {
            arr2[j] = nums[j+1];
        }
        int result1 = rob2(arr1);
        int result2 = rob2(arr2);
        return Math.max(result1,result2);
    }
    public int rob2(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int[] profit = new int[nums.length];
        profit[0] = nums[0];
        profit[1] = Math.max(profit[0],nums[1]);

        for(int i=2;i<nums.length;i++)
        {
            profit[i] = Math.max(nums[i]+profit[i-2],profit[i-1]);
        }
        return profit[nums.length-1];

    }
}