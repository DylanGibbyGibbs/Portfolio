// lets make our own excetion class

//class ShipException extends RuntimeException {

class ShipException extends Exception {

    public ShipException( String mess ) {
             super(mess);
    }
}