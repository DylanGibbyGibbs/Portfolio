/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Random;
import entity.entity;
import main.game_panel;
/**
 *
 * @author ltmer
 */
public class PRO_Shirt extends entity {

    public PRO_Shirt(game_panel gp){
        super(gp);
        
        //Entity Stats
        type = typeProjectile;
        name = "Shirt";
        speed = 8;
        maxLife = 50;
        life = maxLife;
        alive = true;
        damage = 1;
        
     //   solidArea.x = 15;
      //  solidArea.y = 15;
        
      //  solidArea.width = 30;
      //  solidArea.height = 30;
        
        //solidAreaDefaultX = solidArea.x;
       // solidAreaDefaultY = solidArea.y;
        
        get_sprite();
    }
    
    //Gets and Assigns Sprites
    public void get_sprite()
    {
       
        up1 = setup("/misc/shirtup1");
        up2 = setup("/misc/shirtup2");
        down1 = setup("/misc/shirtdown1");
        down2 = setup("/misc/shirtdown2"); 
        left1 = setup("/misc/shirtleft1");
        left2 = setup("/misc/shirtleft2"); 
        right1 = setup("/misc/shirtright1");
        right2 = setup("/misc/shirtright2"); 
    }

    //Projectile always moves in the direction the player is facing
    public void setAction(){
        

        if(gp.projDirection == "up")
        {
            direction = "up";
        }
        if(gp.projDirection == "down")
        {
            direction = "down";
        }
         if(gp.projDirection == "left")
        {
            direction = "left";
        }
        if(gp.projDirection == "right")
        {
            direction = "right";
        }

    }
}
