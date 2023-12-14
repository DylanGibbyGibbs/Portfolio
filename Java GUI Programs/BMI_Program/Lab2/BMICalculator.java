/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author Dylan
 */
 class BMICalculator{
    
    private int feet;
    private int inches;
    private int pounds;
    
    public BMICalculator(int feets, int inchess, int poundss)
    {
     this.setfeet(feets);
     this.setinches(inchess);
     this.setpounds(poundss);
     
    }
    
    public void setfeet(int a) 
    {
         feet = a;
    }
    
    public void setinches(int b) 
    {
         inches = b;
    }
    
    public void setpounds(int c) 
    {
         pounds = c;
    }
    
    public String calculate()
    {
        String results = "";
        int squaredin;
        double dub;
        pounds = this.pounds * 703; //top part of equation
        feet = this.feet * 12; //convert feet into inches
        squaredin = this.inches + feet;
        squaredin = squaredin * squaredin;
        
        dub = Double.valueOf(pounds) / Double.valueOf(squaredin);
        
        results = Double.toString(dub);
        results = results.substring(0, results.indexOf(".")+ 2);
        return results;
    }
    
}
