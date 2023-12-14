/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentquiz;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter; 
import java.io.PrintWriter;
import java.io.BufferedWriter;
/**
 *
 * @author Gibby
 */
public class student {
    
    private String name = "";
    private String id = "";
    private double grade = 0;
    
    
    public void setid(String a)
        {
         id = a;   
        }
    public void setname(String a)
        {
         name = a;   
        }
    public void setgrade(double a)
        {
         grade = a;   
        }
    public void testing()
    {
        System.out.println("name: " +name);
        System.out.println("id: " +id);
        System.out.println("grade: "+grade);
    }
    public String getname()
    {
        return name;
    }
     public void write()
    {
        try{
     
            File stufile = new File("grades.txt");
          if (stufile.createNewFile()) {
            System.out.println("File created: " + stufile.getName());
          } else {
            System.out.println("File already exists.");
          }
          
          FileWriter fw = new FileWriter("grades.txt", true);
         

          
           fw.write("name: " +name + "\nid: " +id + "\ngrade: "+ grade +"\n");
           fw.close();
           // System.out.println("Successfully wrote to the file.");
      
         } catch (IOException e) {
      System.out.println("An error occurred.");
     
         }   
    }
    
}
