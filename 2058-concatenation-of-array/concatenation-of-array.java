class Solution {
    public int[] getConcatenation(int[] nums) {
        int i=0;
        int[] ans = new int[2*nums.length];
        for(i=0;i<nums.length;i++)
        {
            ans[i] = nums[i];
        }
        int j=i;
        i = 0;
        while(i<nums.length)
        {
            ans[j] = nums[i];
            j++ ;
            i++;
        }
        return ans;
    }
}