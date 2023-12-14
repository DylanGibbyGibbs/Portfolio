class HelloWorld // Application class definition
{
public static void main(String[] args) // args can be anything, but it is a common thing because it runs arguments
{
     

      String myname = "Gibby";
      int myage = 70;
      int years_to_retire = 65 - myage;
      if(years_to_retire <= 0)
         {
            System.out.println("Hello " + myname);
            System.out.println("Your age is " + myage);
            System.out.println("You can retire now!");
          }
       else
       {
       System.out.println("Hello " + myname);

       System.out.println("Your age is " + myage);
            System.out.println("You can retire in " + years_to_retire + " years!");
       
         }
}
}