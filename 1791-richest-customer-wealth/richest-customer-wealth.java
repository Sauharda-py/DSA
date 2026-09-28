class Solution {
    public int maximumWealth(int[][] accounts) {
        int max_sum=0;
        for(int i=0;i<accounts.length;i++)
        {
            int cur_sum = 0;
            for(int j=0;j<accounts[0].length;j++)
            {
                cur_sum = cur_sum + accounts[i][j];
            }
            if(cur_sum>max_sum)
            {
                max_sum = cur_sum;
            }
        }
        return max_sum;
    }
}