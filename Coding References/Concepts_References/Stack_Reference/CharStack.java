public class CharStack 
{
// array implementation of a stack


   char data[] = new char[100];
   int top = 0;
   
   public void clear() {
       top =0;
   }
   
   public void push(char val) // puts value on to the stack
    {
       if (top<data.length) 
       {
          data[top]=val;
          top++;
       }
   }
   
   public char pop() // take value off the stack
    {
       if (top>0) 
       {
             top--;
             char rval = data[top];
             return rval;
       }
       return 0;
   } 
   
   public int peek() // checks what value is on top
    {
       if (top>0) 
       {
             int rval = data[top-1];
             return rval;
       }
       return 0;
   }
   
   
     public int size()
   {
     return top;
   }
   
   
   public int nested(String a)
   { 
    // create a charstack
    CharStack check = new CharStack();                   // This CharStack is for putting opening brackets in
    char[] s = a.toCharArray();                          // This will put string a into a character array. This way characters can be manipulated
    
      for(int i = 0; i < s.length; i++)                  
         {
                        if(s[i] == '(' || s[i] == '{' || s[i] == '[' )  // if there is an opening bracket push it to the stack
                           {
                              check.push(s[i]);   
                           }   

                                                    
                        if(s[i] == ')') // if this bracket check to see if the peek value corresponds and pop it off if it does
                            {
                            if(check.peek() == '(')
                                 {
                                 s[i] = 'X';
                                 check.pop();
                                 }
                            }
                        else if(s[i] == '}')
                           {
                           if(check.peek() == '{')
                              {
                              s[i] = 'X';
                              check.pop();
                              }
                           }
                              
                         else if(s[i] == ']')
                           {
                           if(check.peek() == '[')
                              {
                              s[i] = 'X';
                              check.pop();
                              }
                           }
                              
         } 
         
       for(int i = 0; i < s.length; i++)  // This for loop will check for leftover closing brackets indicating an error
         {
            if(s[i] == '}' || s[i] == ')' || s[i] == ']') 
               {
               System.out.println("Error found at: " + i);
               }
         }         
         
         
         
         
         int b = check.size();                           // Get the size
         System.out.println(b);                          // Print the size
         System.out.println(a);                          // Show the original String 
         System.out.println(s);                          // Show the array with the replaced values
         
         if(b == 0)                                      // If the size of the stack is 0
            {
             return -1;                                  // This is valid
            }
         else
           {
             return 1;                                   // This is not valid
           }
        } 
  
public static void main(String s[])
  {
    CharStack dummy = new CharStack();
    if(dummy.nested("(x+y/{a})+[x]") == 1)         // USE THIS LINE TO TEST EACH STRING
      {
       System.out.println("The String Is Inproperly Nested");
      }
    else
      {
       System.out.println("Congratulations! The String Is Properly Nested \n");
      }
      
      
      if(dummy.nested("{f+(c+g})") == 1)         // USE THIS LINE TO TEST EACH STRING
      {
       System.out.println("The String Is Inproperly Nested");
      }
    else
      {
       System.out.println("Congratulations! The String Is Properly Nested");
      }
          
  }
 
}


