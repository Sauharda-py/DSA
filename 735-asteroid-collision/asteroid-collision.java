class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack2 s = new Stack2(asteroids.length);
        int current_top2=-1;
        int current = -1;
        int current_2 = 0;
        for(int i=0;i<asteroids.length;i++)
        {
            boolean neg=false;
            current_top2 = s.current_top();
            if(current_top2!=-1)
                current = s.peek();
            if(asteroids[i]>0)
                s.push(asteroids[i]);
            else if(asteroids[i]<0 && current_top2==-1)
                s.push(asteroids[i]);
            else if(asteroids[i]<0 && current<0)
                s.push(asteroids[i]);
            else if(asteroids[i]<0 && current>0)
            {
                current_top2 = s.current_top();
                if(current_top2!=-1) 
                    current = s.peek();
                current_2 = Math.abs(asteroids[i]);
                while(current_top2!=-1 && current_2>=current && current>0)
                {
                    if(current_2>current)
                    {
                        s.pop();
                        current_top2=s.current_top();
                        if(current_top2!=-1)
                        {
                            current = s.peek();
                        }
                    }
                    else
                    {
                        s.pop();
                        current_top2=s.current_top();
                        if(current_top2!=-1)
                        {
                            current = s.peek();
                        }
                        neg = true;
                        break;
                    }
                        
                }
                if(current_top2==-1 || current_2>=current)
                {
                    if(current_2!=current && neg==false)
                        s.push(asteroids[i]);
                }

            }
        }
        return s.result();
    }
}

class Stack2
{
    int top;
    int size;
    int[] stack;

    Stack2(int size)
    {
        stack = new int[size];
        top=-1;
    }

    public void push(int Value)
    {
        top++;
        stack[top]=Value;
    }
    public void pop()
    {
        top--;
    }
    public int peek()
    {
        return stack[top];
    }
    public int current_top()
    {
        return top;
    }
    public int[] result()
    {
        int final_size = top+1;
        int[] result = new int[final_size];
        for(int i=0;i<=top;i++)
        {
            result[i] = stack[i];
        }
        return result;
    }
}