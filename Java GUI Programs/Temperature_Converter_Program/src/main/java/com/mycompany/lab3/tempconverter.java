/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

/**
 *
 * @author Gibby
 */
public class tempconverter {
    private double temperature;
    private String sign;
    
    
public tempconverter(double temperatures, String signs)
{
    this.settemp(temperatures);
    this.setsign(signs);
}
//simple setters
public void settemp(double a)
{
 temperature = a;   
}
public void setsign(String b)
{
 sign = b;
}
public String getsign()
{
    return sign;
}
public double getnum()
{
    return temperature;
}

//Actual heavy lifting and calculation
public String run() 
{
    String results = "";
    double mynum = getnum();
    
    if(this.getsign().equals("Fahrenheit") == true)
    {
        mynum = mynum - 32;
        mynum = mynum * 5;
        mynum = mynum / 9;
        results = Double.toString(mynum);
        results = results.substring(0, results.indexOf(".")+ 2);   
    }
    if(this.getsign().equals("Celsius") == true)
    {
        mynum = mynum * 1.8;
        mynum = mynum + 32;
        results = Double.toString(mynum);
        results = results.substring(0, results.indexOf(".") + 2);
    }
    
    
    return results;
}

}