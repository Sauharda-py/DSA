class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n!=0 && m!=0)
        {
            for(int i=m,j=0;i<(m+n) && j<n;i++,j++)
            {
                nums1[i] = nums2[j];
            }
            
        }
        else if(m==0)
        {
             for(int i=0;i<n;i++)
            {
                nums1[i] = nums2[i];
            }
        }
        quick_sort(nums1,0,(m+n-1));
    }

    void quick_sort(int[] arr, int start,int end)
    {
        if(start>=end)
            return;
        int j=start;
        int i=j-1;
        int pivot_index = end;
        while(j!=pivot_index)
        {
            if(arr[j]>arr[pivot_index])
            {
                j++;
            }
            else if(arr[j]<=arr[pivot_index])
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        i++;
        int temp = arr[pivot_index];
        arr[pivot_index] = arr[i];
        arr[i] = temp;
        quick_sort(arr,start,i-1);
        quick_sort(arr,i+1,end);
        
    }
}