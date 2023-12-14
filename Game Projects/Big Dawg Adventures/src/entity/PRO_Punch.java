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
public class PRO_Punch extends entity {

    public PRO_Punch(game_panel gp){
        super(gp);
        
        //Entity Stats
        type = typeProjectile;
        name = "Punch";
        speed = 5;
        maxLife = 10;
        life = maxLife;
        alive = true;
        damage = 2;
        
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
       
        down1 = setup("/misc/glovedown");
        down2 = setup("/misc/glovedown");
        up1 = setup("/misc/gloveup");
        up2 = setup("/misc/gloveup");
        right1 = setup("/misc/gloveright");
        right2 = setup("/misc/gloveright");
        left1 = setup("/misc/gloveleft");
        left2 = setup("/misc/gloveleft");
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
