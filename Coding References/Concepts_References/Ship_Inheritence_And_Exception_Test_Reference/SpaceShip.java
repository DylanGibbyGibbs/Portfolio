
class SpaceShip extends Ship {

     private int hyperDrives;
     
     public int getHyper() {
         return hyperDrives;
     }
     
     @Override
     public int getValue() {
         return super.getValue() + 100000 + 20000 * hyperDrives;
     }
     
     // start the hyper drives
     // the topspeed must be >1000
     public int engageDrives() {
          if (topspeed>1000)
          {
              System.out.println("Drives engaged!!");
              return 1;
          } else {
              System.out.println("Drives NOT engaged!!");
              return 0;
          } 
     }
     
     public void setHyper(int h) {
         if (h>=0) {
             this.hyperDrives=h;
         } else {
             System.out.println("Error in hyper drives");
         }
     }
     
     // override the ship classes toString
     @Override public String toString() {
         return super.toString() + " | hyperDrives = " + this.hyperDrives;
     }
     
     public SpaceShip(String id, int s, int c) {
         // call the super class constructor
         super(id,s,c);
     }
     public SpaceShip(String id, int s, int c, int h) {
         // call the super class constructor
         super(id,s,c);
         this.setHyper(h);
     }
}