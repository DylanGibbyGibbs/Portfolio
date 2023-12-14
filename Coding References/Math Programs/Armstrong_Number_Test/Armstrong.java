public class Armstrong
{
public static void main(String[] args)
{
int a = Integer.parseInt(args[0]); // input
int r = a % 10; // last value
int m = a / 10;
int ma = m % 10; // middle value
int l = a / 100; // first value
int cube = r * r * r + ma * ma * ma + l * l * l; // sum of the cubes

if(cube == a)
   System.out.println("The number is an Armstrong number");
else
   System.out.println("The number is not an Armstrong number");

}
}