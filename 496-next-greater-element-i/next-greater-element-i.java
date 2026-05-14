import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<Integer>();
        int[] nge = new int[nums2.length];

        for(int i=nums2.length-1;i>=0;i--)
        {
            if(s.empty())
            {
                nge[i]=-1;
                s.push(nums2[i]);
            }
            else
            {
                int current = s.peek();
                while(nums2[i]>current && !s.empty())
                {
                    s.pop();
                    if(!s.empty())
                        current = s.peek();
                }
                if(!s.empty())
                    nge[i] = s.peek();
                else
                    nge[i] = -1;
                s.push(nums2[i]);
            }
        }

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {

            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    result[i] = nge[j];
                }
            }
        }
        return result;
    }
}