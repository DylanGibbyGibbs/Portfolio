class Loader extends Tractor
{
private int bucksize;

               // Getters
               public int getbucksize() 
               {
               return bucksize;
               }


               // Setters
               public void setbucksize(int newbucksize) throws TractorException
                  {
                  if(0 < newbucksize && newbucksize <= 5)
                     {
                        bucksize = newbucksize;
                     }
                  else
                     {
                        throw new TractorException("Error: Not 1-5 Bucket Size: " + newbucksize);
                     }
                   }
                  
               
              
                  
               // Replaces original parameterized constructor  
               public Loader(int i, int r, int d, int b) throws TractorException
               {
                  this.setid(i);
                  this.setrate(r);
                  this.setdays(d);
                  this.setbucksize(b);
               }
            
                  
                //zero parameter constructor
                public Loader()
                  {
                
                  id = 0;
                  rate = 0;
                  days = 0;
                  bucksize = 0;
                  }
         
                 // Display information
                 public String toString()
                  {
                 return owner + " Loader VIN: " + id + " is being rented for " + days + " days at a rate of " + rate + " and has a bucket size of " + bucksize ; 
                  }    
                  
                  
                     // overidden profit string
                     public String rentalprofit()
                  {
                    int pro = days * rate + bucksize * 100 ;
                   return "Profit from " + days + " days at rate of " + rate + " is " + pro; 
                  }
               
   

}