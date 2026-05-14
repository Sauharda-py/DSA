import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] nge = new int[nums2.length];

        for(int i=nums2.length-1;i>=0;i--)
        {
            if(s.empty())
            {
                hm.put(nums2[i],-1);
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
                    hm.put(nums2[i],s.peek());
                else
                    hm.put(nums2[i],-1);
                s.push(nums2[i]);
            }
        }

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            result[i] = hm.get(nums1[i]);
        }
        return result;
    }
}