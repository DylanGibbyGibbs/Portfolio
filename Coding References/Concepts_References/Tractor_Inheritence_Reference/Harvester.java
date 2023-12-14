class Harvester extends Tractor
{
   private int trailop;
   
   
               // Getters
               public int gettrailop() 
               {
               return trailop;
               }
               
               //Setters
               public void settrailop(int newtrailop) throws TractorException
               {
               if(newtrailop > 0 && newtrailop <= 3)
                  {
                     this.trailop = newtrailop;
                  }
               else
                  {
                     throw new TractorException("Error: Not a 1-3 Trailer Option: " + newtrailop);
                  }
                }
               
               
               
               
               public void setdays(int newdays) throws TractorException
               {
               if(newdays >= 20)
                  {
                     this.days = newdays;
                  }
               else
                  {
                     throw new TractorException("Error: Harvester Rental Period Too Short: " + newdays);
                  }
               }  

          
                  
                  public Harvester(int i, int r, int d, int t) throws TractorException
               {
                  super(i, r, d);
                  this.settrailop(t);
               } 
                  
                  
                  
                  
               public Harvester()
                  {
                  
                  id = 0;
                  rate = 0;
                  days = 0;
                  trailop = 0;
                  }
                  
                   // Display information
                 public String toString()
                  {
                 return owner + " Harvester VIN: " + id + " is being rented for " + days + " days at a rate of " + rate + " and has a trailer size of " + trailop ; 
                  }    
                  
                  
                     // overidden profit string
                     public String rentalprofit()
                  {
                    int pro = days * rate + trailop * 1000 ;
                   return "Profit from " + days + " days at rate of " + rate + " is " + pro; 
                  }
               
                  
                  
                  
                  
   }