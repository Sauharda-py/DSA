class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int ideal = length/2+1;
        int max_count = 0;
        int ideal_element = -1;
        for(int i=0;i<length;i++)
        {
            int count=0;
            for(int j=i;j<length;j++)
            {
                if(nums[j]==nums[i])
                    count++;
            }
            if(count>=ideal && count>max_count)
            {
                ideal_element=nums[i];
                max_count=count;
                
            }
        }
        return ideal_element;

    }
}