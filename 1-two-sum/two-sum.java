class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        {
            int sum = nums[i];
            int j;
            for(j=i+1;j<nums.length;j++)
            {
                sum = sum + nums[j];
                if(sum == target)
                {
                int[] result = {i,j};
                return result;
                }
                else
                {
                    sum = nums[i];
                }
            }

        }
        int[] result = {-1,-1};
        return result;
    }
}