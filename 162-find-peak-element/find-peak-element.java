class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
        {
            return 0;
        }
        if(nums.length==2)
        {
            if(nums[0]>nums[1])
                return 0;
            else
                return 1;
        }
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(mid!=0 && mid!=nums.length-1)
            {
                if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                    return mid;
                else if(nums[mid]>nums[mid-1])
                    start = mid+1; //peak must be on right of mid
                else
                    end = mid-1;//peak must be on left of mid
            }
            else
            {
                if(mid==0 && nums[mid]>nums[mid+1])
                    return mid;
                else if(mid==0 && nums[mid]<nums[mid+1])
                    return mid+1;
                else if(mid==nums.length-1 && nums[mid]>nums[mid-1])
                    return mid;
                else
                    return mid-1;
            }
        }
        return start;
    }
}