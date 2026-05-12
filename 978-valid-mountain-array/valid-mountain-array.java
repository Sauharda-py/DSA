class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3)
            return false;
        //Finding the max from the array
        int max = -1;
        int max_index = -1;
        for(int i=1;i<arr.length-1;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];//9
                max_index = i;//2
            }
        }
        for(int i=0;i<=max_index-1;i++)
        {
            if(arr[i]>=arr[i+1])
                return false;
        }
        for(int j=max_index;j<arr.length-1;j++)
        {
            if(arr[j]<=arr[j+1])
                return false;
        }
        return true;
    }
}