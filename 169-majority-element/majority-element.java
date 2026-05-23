import java.util.Arrays;
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int ideal = nums.length/2;
        for(int i=ideal;i<nums.length;i++)
        {
            if(nums[i]==nums[i-ideal])
                return nums[i];
        }
        return -1;
    }
}