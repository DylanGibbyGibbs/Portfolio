// test the ship class

class TestShip {

    public static void main(String a[]) {
    
    try{
        // create an instance of ship
        Ship myship = new Ship();
        // myship is an instance(object) of the Ship class
        
        
        // test its attributes
        // myship.shipid="Terry";
        myship.setID("Terry");
        myship.setTopSpeed(-777);
        
        myship.display();
        //System.out.println("myship.getID() " + myship.getID() );
        //System.out.println("myship.topspeed() " + myship.getTopSpeed() );
    
    
        // test its methods
        
        
        Ship ship2 = new Ship();
        ship2.display();
        //System.out.println("ship2.getID() " + ship2.getID() );
        

        Ship ship3 = new Ship("Voyager",880, 220);
        ship3.display();
        System.out.println(ship3);
        System.out.println(ship3.toString());
                
        //System.out.println("ship3.getID() " + ship3.getID() );
        
        myship.owner = "Terry";
        System.out.println("ship3.owner " + ship3.owner );   
        
        
        SpaceShip myspaceship = new SpaceShip("Galactica",100000,8888,12);
        myspaceship.setID("Gala333");
        System.out.println(myspaceship);       
        
        Ship fleet[] = new Ship[100];
        fleet[0]=myship;
        fleet[1]=ship2;
        fleet[2]=ship3;   
        fleet[3]=myspaceship;  
        
        displayFleet(fleet,4);
        //fleet[4]=new Captain();
        
    } catch (ShipException e) {
        System.out.println(e.getMessage());
    } catch (Exception e) {
        System.out.println("General Exception");
    }
  }
    
    public static void displayFleet(Ship f[], int count) {
        int totalvalue=0;
        for(int idx = 0; idx<count; idx++){
        
             // the total value of the fleet
             totalvalue += f[idx].getValue();
            
             System.out.println("Ship"+idx+" = " + f[idx].toString());
             
             if (f[idx] instanceof SpaceShip){
                
                  // type cast the ship to be treated like a spaceship
                  SpaceShip t = (SpaceShip)f[idx];
                  System.out.println("--This space ship has hyperdrives = " +
                           t.getHyper() );
             }
        }
        System.out.println("Total Value = " + totalvalue);
    }
}