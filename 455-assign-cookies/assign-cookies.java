class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int[] assigned = new int[s.length];

        Arrays.sort(g);
        Arrays.sort(s);
        
        for(int i=0;i<assigned.length;i++)
        {
            assigned[i] = -1;
        }
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<s.length;j++)
            {
                if(s[j]>=g[i] && assigned[j]==-1)
                {
                    count+=1;
                    assigned[j]=0;
                    break;
                }
            }
        }
        return count;
    }
}