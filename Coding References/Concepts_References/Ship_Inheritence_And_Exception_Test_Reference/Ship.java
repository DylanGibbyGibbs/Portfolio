// shipping business example

class Ship extends Asset {

    @Override
    public int getValue() {
        return 50000;
    }

    // make instance/object variables private
    // so they can be valiadated in methods
    private String shipid;
    private int cargocapacity;
    protected int topspeed;
    protected Captain captain;
    
    // static attibutes are shared by all objects in the class
    // and are also called class attributes.
    public static String owner;

    // a set method "setters" for the shipid
    public void setID(String id) {
         shipid = id;
    }
    
    public void display() {
         System.out.println("id = " + this.shipid + " | topspeed = " + this.topspeed +
             " | cargocapacity = "+this.cargocapacity );
    }
    
    // override the inherited toString()
    public String toString() {
         return "id = " + this.shipid + " | topspeed = " + this.topspeed +
             " | cargocapacity = "+this.cargocapacity + " | captain = " + captain.name;
    }
    
    // a get method "getter" returns an attribute value
    public String getID() {
         return shipid;
    }   
    
    // a set method "setters" for the topspeed
    public void setTopSpeed(int topspeed) throws ShipException {
         if (topspeed>=0) 
             // the word this clarifies the name confusion
             this.topspeed = topspeed;
         else {
             throw new ShipException("Error top speed " + topspeed);
             //System.out.println("Error top speed " + topspeed );             
         }
    }
    
    // a get method "getter" returns an attribute value
    public int getTopSpeed() {
         return topspeed;
    }   
    
    
    // a set method "setters"
    public void setCargoCapacity(int car) {
         if (car>=0) 
             cargocapacity = car;
         else {
             System.out.println("Error cargo capacity " + car );
         }
    }
    
    // a get method "getter" returns an attribute value
    public int getCargoCapacity() {
         return cargocapacity;
    }     
    
    // a zero parameter replaces default constructor
    public Ship() {
         this.shipid = "[unassigned]";
         this.topspeed = 0;
         this.cargocapacity = 0;
         this.captain = new Captain();
    }     


    // a parameterized constructor
    // an overloaded contructor
    // different method signatures (parameters)
    public Ship(String i, int s, int c) throws ShipException {
         this.setID(i);
         this.setTopSpeed(s);
         this.setCargoCapacity(c);
         this.captain = new Captain();
    }  


}