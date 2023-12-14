/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.entity;
import java.awt.*;
import java.awt.image.BufferedImage;;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import object.OBJ_Bone;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.OBJ_Bone;



/**
 *
 * @author ltmer
 */
public class user_interface {
    
    game_panel gp;
    Graphics2D g2;
    Font arial_40, arial_80B, Arcade, Comic;
    public int commandNum = 0;   //counter for menu options
    public String currentDialogue;

    //Buff Images for Life
    BufferedImage Fullbone, TQbone, Halfbone, Qbone, Emptybone;
    
    //Buff Images for Menu
    BufferedImage tShirtIcon, boxingIcon, helmetIcon, bootsIcon, controlScreen;
    
    
    //construtor to communicate current game state
    public user_interface(game_panel gp){
        this.gp = gp;
        
       
       
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/ARCADECLASSIC.TTF");
            Arcade = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("/fonts/dpcomic.ttf");
            Comic = Font.createFont(Font.TRUETYPE_FONT, is);
            } 
        catch (FontFormatException ex) 
            {
            ex.printStackTrace();
            }
        catch (IOException ex) 
        {
           ex.printStackTrace();
        }
        
        
        entity bone = new OBJ_Bone(gp);
        Fullbone = bone.image;
        TQbone = bone.image2;
        Halfbone = bone.image3;
        Qbone = bone.image4;
        Emptybone = bone.image5;
        
      //  Icons for Weapon Select
        UtilityTool utool = new UtilityTool();
        try {
            tShirtIcon = ImageIO.read(getClass().getResourceAsStream("/misc/tshirt_cannon.png")); //Read the sprite path
            boxingIcon = ImageIO.read(getClass().getResourceAsStream("/misc/glovedown.png"));
            helmetIcon = ImageIO.read(getClass().getResourceAsStream("/misc/helmet-1.png"));
            bootsIcon = ImageIO.read(getClass().getResourceAsStream("/misc/Sneaker.png"));
            controlScreen = ImageIO.read(getClass().getResourceAsStream("/misc/Controls.png"));
        } catch (IOException ex) {
        }
        
    }
    
    
    
    //decides what state to draw and coorilating draw function
    public void draw(Graphics2D g2){
        this.g2=g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //Play State
        if(gp.gameState == gp.play){
            
            
            drawPlayerLife();
            
        }
        //Pause State
        if(gp.gameState == gp.pause){
            drawPauseScreen();
        }
        //Title State
        if(gp.gameState == gp.title){
            drawTitleScreen();
        }
        //Settings State
        if(gp.gameState == gp.settings){
            drawSettingsScreen();
        }
        //Quit
        if(gp.gameState == gp.quit)
        {
            //Save and Quit needs to be implemented here. 
            System.exit(0);
        }
        //Dialogue
        if(gp.gameState == gp.dialogue){
            drawDialogue();
            
            drawPlayerLife();
        }
        //Dead
        if(gp.gameState == gp.dead){
            drawDeadScreen();
        }
        
        //Controls
        if(gp.gameState == gp.control){
            drawControlScreen();
        }
        
        //WIN
        if(gp.gameState == gp.win){
            drawWinScreen();
        }
    }
    
    
    public void drawPlayerLife()
    {
        int x = gp.tile_size - 50;
        int y = 8 * gp.tile_size;
        int player_life = gp.myplayer.life;
        
        
     
       switch(player_life)
               {
        case 1:
                   g2.drawImage(Emptybone, x, y, null);
                   break;
        case 2:
                   g2.drawImage(Qbone, x, y, null);
                   break;
        case 3:
                   g2.drawImage(Halfbone, x, y, null);
                   break;
        case 4:
                   g2.drawImage(TQbone, x, y, null);
                   break;
        case 5:
                   g2.drawImage(Fullbone, x, y, null);
                   break;
        case 6:
                   g2.drawImage(Fullbone, x, y, null);
                   g2.drawImage(helmetIcon, x+gp.tile_size, y, gp.tile_size, gp.tile_size, null);
                   break;
        case 7:
                   g2.drawImage(Fullbone, x, y, null);
                   g2.drawImage(helmetIcon, x+gp.tile_size-10, y, gp.tile_size, gp.tile_size, null);
                   g2.drawImage(helmetIcon, x+gp.tile_size+32, y, gp.tile_size, gp.tile_size, null);
                   break;
               }
    
  
           
           
        
        
    }
    
    //Draws title screen menu
    public void drawTitleScreen(){
        
        
        g2.setColor(new Color(83, 1, 130));
        g2.fillRect(0,0,gp.screen_width,gp.screen_height);
        
        //Title Name
        g2.setFont(Comic.deriveFont(Font.BOLD,96F));
        String text = "Big Dawg Adventures";
        int x = getCenterX(text);
        int y = gp.tile_size*3/2;
        
        //SHADOW
        g2.setColor(Color.black);
        g2.drawString (text, x+5, y+5);
        //Main
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        //Rocky Icon
        x=gp.screen_width/2 - gp.tile_size;
        y=gp.tile_size*2;
        g2.drawImage(gp.myplayer.down1, x, y, gp.tile_size*2, gp.tile_size*2, null);
        
        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));      
        
        //SELECTION OPTIONS
        
        text = "New Game";
        x = getCenterX(text);
        y = gp.tile_size*5;
        g2.drawString(text,x,y);
        if (commandNum==0){
            g2.drawString("*",x-30,y);
        }
        
        text = "Load Save";
        x = getCenterX(text);
        y = gp.tile_size*6;
        g2.drawString(text,x,y);
        if (commandNum==1){
            g2.drawString("*",x-30,y);
        }
        
        text = "Settings";
        x = getCenterX(text);
        y = gp.tile_size*7;
        g2.drawString(text,x,y);
        if (commandNum==2){
            g2.drawString("*",x-30,y);
        }
        
        text = "Quit";
        x = getCenterX(text);
        y = gp.tile_size*8;
        g2.drawString(text,x,y);
        if (commandNum==3){
            g2.drawString("*",x-30,y);
        }
        
    }
    
    //Draws Pause screen
    public void drawPauseScreen(){
        
        //background
        g2.setColor(new Color(83, 1, 130, 100));
        g2.fillRect(0,0,gp.screen_width,gp.screen_height);
        
        //Pause Box
        int x = gp.tile_size*4;
        int y = gp.tile_size/2;
        int width = gp.tile_size*8;
        int height = gp.tile_size*8;
        drawSubWindow(x,y,width,height);
        
        //Pause Title
        g2.setFont(Comic.deriveFont(Font.BOLD,60F));
        String text = "INVENTORY";
        g2.drawString(text,getCenterX(text) , y+gp.tile_size);
        
        //Weapon SubBox
        x = gp.tile_size*7;
        y = gp.tile_size*2+16;
        width = gp.tile_size*2;
        height = gp.tile_size*2;
        drawSubWindow(x,y,width,height);
        
        //Draw Icons for Weapon SubBox
        if(gp.weaponSelect==gp.tShirtCannon){
            x=gp.screen_width/2 - gp.tile_size+10;
            y=gp.tile_size*2 +25;
            g2.drawImage(tShirtIcon, x, y, gp.tile_size*2-20, gp.tile_size*2-20, null);
        }else if(gp.weaponSelect==gp.boxingGlove){
            x=gp.screen_width/2 - gp.tile_size+10;
            y=gp.tile_size*2+25;
            g2.drawImage(boxingIcon, x, y, gp.tile_size*2-20, gp.tile_size*2-20, null);
        }
        
        //Armor SubBox
        x = gp.tile_size*7;
        y = gp.tile_size*5;
        width = gp.tile_size*2;
        height = gp.tile_size*2;
        drawSubWindow(x,y,width,height);
        
        //Draw Icons for Armor SubBox
        if(gp.armorSelect==gp.boots){
            x=gp.screen_width/2 - gp.tile_size+10;
            y=gp.tile_size*5;
            g2.drawImage(bootsIcon, x, y, gp.tile_size*2-20, gp.tile_size*2-20, null);
        }else if(gp.armorSelect==gp.helmet){
            x=gp.screen_width/2 - gp.tile_size+10;
            y=gp.tile_size*5;
            g2.drawImage(helmetIcon, x, y+20, gp.tile_size*2-20, gp.tile_size*2-20, null);
        }
        
        //Selection Options
        g2.setFont(Comic.deriveFont(Font.BOLD,32F));
        text = "WEAPON";
        x = getCenterX(text);
        y = gp.tile_size*2;
        g2.drawString(text,x,y);
        if (commandNum==0){  
            x = getCenterX("");
            y = gp.tile_size*2;
            g2.drawString("*",x-gp.tile_size-16,y);
            g2.setFont(Comic.deriveFont(Font.BOLD,64F));
            g2.drawString("<",x-gp.tile_size*2,y+gp.tile_size+32);
            g2.drawString(">",x+gp.tile_size*2-32,y+gp.tile_size+32);
            g2.setFont(Comic.deriveFont(Font.BOLD,32F));
        }
        
        text = "ARMOR";
        x = getCenterX(text);
        y = gp.tile_size*5 - 16;
        g2.drawString(text,x,y);
        if (commandNum==1){
            x = getCenterX("");
            y = gp.tile_size*5-16;
            g2.drawString("*",x-gp.tile_size-16,y);
            g2.setFont(Comic.deriveFont(Font.BOLD,64F));
            g2.drawString("<",x-gp.tile_size*2,y+gp.tile_size+32);
            g2.drawString(">",x+gp.tile_size*2-32,y+gp.tile_size+32);
            g2.setFont(Comic.deriveFont(Font.BOLD,32F));
        }
        
        text = "Continue";
        x = gp.tile_size*5-16;
        y = gp.tile_size*8;
        g2.drawString(text,x,y);
        if (commandNum==2){
            g2.drawString("*",x-30,y);
        }
        
        text = "Save Game";
        x = gp.tile_size*7+16;
        y = gp.tile_size*8;
        g2.drawString(text,x,y);
        if (commandNum==3){
            g2.drawString("*",x-30,y);
        }
        
        text = "Quit";
        x = gp.tile_size*10+32;
        y = gp.tile_size*8;
        g2.drawString(text,x,y);
        if (commandNum==4){
            g2.drawString("*",x-30,y);
        }    
    }
      
    //Draws Settings Screen
    public void drawSettingsScreen(){
        //background
        g2.setColor(new Color(83, 1, 130));
        g2.fillRect(0,0,gp.screen_width,gp.screen_height);
        
        //Title Name
        g2.setFont(Comic.deriveFont(Font.BOLD,96F));
        String text = "Settings"; 
        int x = getCenterX(text);
        int y = gp.screen_height/5;
        
        //SHADOW
        g2.setColor(Color.black);
        g2.drawString (text, x+5, y+5);
        //Main
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        
        
        //SELECTION OPTIONS
        
        text = "View controls";
        x = getCenterX(text);
        y = gp.tile_size*4;
        g2.drawString(text,x,y);
        if (commandNum==0){
            g2.drawString("*",x-30,y);
        }
         
        if(gp.soundState==gp.soundOn){
            text = "Sound[X]";
          
        }else if(gp.soundState==gp.soundOff){
            text = "Sound[   ]";
          
        }
        x = getCenterX(text);
        y = gp.tile_size*5;
        g2.drawString(text,x,y);
        if (commandNum==1){
            g2.drawString("*",x-30,y);
        }
        
        text = "Back to title";
        x = getCenterX(text);
        y = gp.tile_size*6;
        g2.drawString(text,x,y);
        if (commandNum==2){
            g2.drawString("*",x-30,y);
        }
    }
        
    public void drawControlScreen(){
       g2.drawImage(controlScreen, 0, 0, null); 
    }
    public void drawDialogue(){
        //Dialogue window
        int x = gp.tile_size*5;
        int y = gp.tile_size/2;
        int width = gp.tile_size*6;
        int height = gp.tile_size*3;
        drawSubWindow(x,y,width,height);
        
        g2.setFont(Comic.deriveFont(Font.PLAIN, 26));
        x = x+15;
        y = y+30;
        
        for(String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y += 30;
        }
        
    }
    
    //GameOver Screen
    public void drawDeadScreen(){
        //background
        g2.setColor(new Color(46, 45, 43, 150));
        g2.fillRect(0,0,gp.screen_width,gp.screen_height);
        
        //Title Name
        g2.setFont(Comic.deriveFont(Font.BOLD,64F));
        String text = "Game Over"; 
        int x = getCenterX(text);
        int y = gp.screen_height/5;
        
        //SHADOW
        g2.setColor(Color.black);
        g2.drawString (text, x+5, y+5);
        
        //Main
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        g2.setFont(Comic.deriveFont(Font.BOLD,48F));
        text = "Back to title";
        x = getCenterX(text);
        y = gp.tile_size*4;
        g2.drawString(text,x,y);
        if (commandNum==0){
            g2.drawString("*",x-30,y);
        }
        
        text = "Quit Game";
        x = getCenterX(text);
        y = gp.tile_size*6;
        g2.drawString(text,x,y);
        if (commandNum==1){
            g2.drawString("*",x-30,y);
        }
        
    }
    
    //WIN SCREEN!!!
    public void drawWinScreen(){
        //background
        g2.setColor(new Color(252, 201, 61, 150));
        g2.fillRect(0,0,gp.screen_width,gp.screen_height);
        
        //Title Name
        g2.setFont(Comic.deriveFont(Font.BOLD,64F));
        String text = "YOU SAVED THE TOWN!!!"; 
        int x = getCenterX(text);
        int y = gp.screen_height/5;
        
        //SHADOW
        g2.setColor(Color.black);
        g2.drawString (text, x+5, y+5);
        
        //Main
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        g2.setFont(Comic.deriveFont(Font.BOLD,48F));
        text = "Back to title";
        x = getCenterX(text);
        y = gp.tile_size*4;
        g2.drawString(text,x,y);
        if (commandNum==0){
            g2.drawString("*",x-30,y);
        }
        
        text = "Quit Game";
        x = getCenterX(text);
        y = gp.tile_size*6;
        g2.drawString(text,x,y);
        if (commandNum==1){
            g2.drawString("*",x-30,y);
        }
        
    }
    
    //Draws small box for dialogue/settings 
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color (0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c=new Color(255,255,255,200);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
    
    //gets the center of X axis, used in state drawing
    public int getCenterX(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screen_width/2 - length/2;
        return x;
    }
    
    
    
}
