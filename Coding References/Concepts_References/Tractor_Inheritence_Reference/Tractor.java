class Tractor
{
  
    
   public static String owner;
   protected int id;
   protected int rate;
   protected int days;
   
               //Getters
            public int getid() 
               {
               return id;
               }
            
            public int getrate()
               {
               return rate;
               }
            
            public int getdays()
               {
               return days;
               }
            
            
            //Setters
           public void setowner(String newowner)
           {
           owner = newowner;
           }
          
          
             public void setid(int newid) throws TractorException
               {
               if(newid >= 0)
                  {
                     id = newid;
                  }
               else 
                  {
                     throw new TractorException("Error: ID less than 0: " + newid);
                  }
               }
               
             public void setrate(int newrate) throws TractorException
               {
               if(newrate >= 0)
                  {
                     rate = newrate;
                  }
               else
                  {
                   throw new TractorException("Error: Rate less than 0: " + newrate);
                  }
               }
               
             public void setdays(int newdays) throws TractorException
               {
               if(newdays >= 0)
                  {
                    days = newdays;
                  }
               else 
                  {
                    throw new TractorException("Error: Days less than 0: " + newdays);        
                  }
               }
         
            
            // zero parameter constructor
            public Tractor() 
               {
                  id = 0;
                  rate = 0;
                  days = 0;
               }
         
      
           
            //This Replaces the parameterized constructor and allows it to account for exceptions
            public Tractor(int i, int r, int d) throws TractorException
               {
                  this.setid(i);
                  this.setrate(r);
                  this.setdays(d);
               }
            
            
   
   
 
   
   public String rentalprofit()
      {
        int pro = days * rate ;
       return "Profit from " + days + " days at rate of " + rate + " is " + pro; 
      }
      
      
      
      // toString() will work. All objects have toString. By default it returns objects memory adress. we can overide this and make this work with display instructions.
   public String toString()
      {
     return owner + " Tractor VIN: " + id + " is being rented for " + days + " days at a rate of " + rate; 
      }    
      
      
     
      
      
      
      
      
      
      
      
      
      
   
   }