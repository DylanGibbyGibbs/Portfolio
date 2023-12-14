public class Tip
{
public static void main(String[] args)
{
float i = Float.parseFloat(args[0]);

System.out.println("10%: $" + i * 0.10);
System.out.println("15%: $" + i * 0.15);
System.out.println("20%: $" + i * 0.20);

}
}