class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack2 s = new Stack2(asteroids.length);
        int current_top2=-1; //inidicates the current top index
        int current = -1; //indicates the element at the top of the stack
        int current_2 = 0;  //indicates the abs value of the array
        for(int i=0;i<asteroids.length;i++)
        {
            boolean neg=false; 
            current_top2 = s.current_top();
            if(current_top2!=-1)
                current = s.peek();
            //if the element is +ve push immediately
            if(asteroids[i]>0)
                s.push(asteroids[i]);
            //if the element is -ve but the stack is empty push immediately
            else if(asteroids[i]<0 && current_top2==-1)
                s.push(asteroids[i]);
            //if the element is -ve but the stack top is -ve push immediately
            else if(asteroids[i]<0 && current<0)
                s.push(asteroids[i]);
            //if the element is -ve but the stack top is +ve
            else if(asteroids[i]<0 && current>0)
            {
                current_top2 = s.current_top();
                if(current_top2!=-1) 
                    current = s.peek();
                current_2 = Math.abs(asteroids[i]);
                //keep popping until the stack is empty or the the first element is -ve
                //or the first element is +ve and the asteroid is bigger than it.
                while(current_top2!=-1 && current_2>=current && current>0)
                {
                    //if the asteroid is greater than the +ve stack top
                    if(current_2>current)
                    {
                        s.pop();
                        current_top2=s.current_top();
                        if(current_top2!=-1)
                        {
                            current = s.peek();
                        }
                    }
                    //if the asteroid is equal to the +ve stack top
                    else
                    {
                        s.pop();
                        current_top2=s.current_top();
                        if(current_top2!=-1)
                        {
                            current = s.peek();
                        }
                        //in case the -ve asteroid and +ve top are same
                        //neg = true and just break
                        neg = true;
                        break;//breaks from the while loop;
                    }
                        
                }
                //this is outside the while loop
                if(current_top2==-1 || current_2>=current)
                {   
                    //push only in the case of the asteroid is -ve and greater than the +ve top;
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