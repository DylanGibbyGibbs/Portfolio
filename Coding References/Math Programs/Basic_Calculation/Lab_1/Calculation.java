
class Calculation
   {
   //a few variables
      private double firstnumber;
      private double secondnumber;
      
   
   
   //basic constructor
   public Calculation(double one, double two) 
            {
            this.setnumone(one);  
            this.setnumtwo(two);
            } 
        
   //Setters           
   public void setnumone(double a) 
    {
         firstnumber = a;
    }

   public void setnumtwo(double c) 
    {
         secondnumber = c;
    }
    
    
   //math methods
   public void add()
      {
      System.out.print("Results:   ");
      System.out.print(this.firstnumber + this.secondnumber);
      }
   public void sub()
      {
      System.out.print("Results:   ");
      System.out.print(this.firstnumber - this.secondnumber);
      }
   public void mul()
      {
      System.out.print("Results:   ");
      System.out.println(this.firstnumber * this.secondnumber);
      }
   public void div()
      {
      double ph = this.firstnumber / this.secondnumber;
      String str = Double.toString(ph); 
      int format = str.indexOf(".");
      System.out.print("Results:   ");
      
       
      //Allows for the formatting of up to two decimal places.
      if(str.substring(format).length() > 2) //if number doesnt match desired format 
         {
          System.out.println(str.substring(0, format+3));
         }
      else
         {
         System.out.println(str);
         }
      }
      
    
   }   
        
    