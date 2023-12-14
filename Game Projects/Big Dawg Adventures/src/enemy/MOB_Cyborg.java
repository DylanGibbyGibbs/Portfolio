/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemy;

import java.util.Random;
import entity.entity;
import main.game_panel;
import java.lang.Math;
/**
 *
 * @author ltmer
 */
public class MOB_Cyborg extends entity{
    int distanceY, distanceX;
    
    public MOB_Cyborg(game_panel gp){
        super(gp);
     
        //indicates that it is an enenmy and not friendly
        type = typeEnemy; 
        
        //Stats
        name = "Cyborg";
        speed = 2;
        maxLife = 4;
        life = maxLife;
        alive = true;
        damage = 2;
        
        //Hitbox Stats :)
        solidArea.x = 6;
        solidArea.y = 10;
        
        solidArea.width = 39;
        solidArea.height = 35;
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        get_sprite();
    }
    
    
    public void get_sprite()
    {
       
        down1 = setup("/Enemy/foward1CyRock");
        down2 = setup("/Enemy/foward2CyRock");
        up1 = setup("/Enemy/back1CyRock");
        up2 = setup("/Enemy/back2CyRock");
        right1 = setup("/Enemy/right1CyRock");
        right2 = setup("/Enemy/right2CyRock");
        left1 = setup("/Enemy/left1CyRock");
        left2 = setup("/Enemy/left2CyRock");
    }
    
    public void setAction()
    {
        distanceX = xDistance();
        distanceY = yDistance();
        
        Random random = new Random();
        int i = random.nextInt(100)+1; //Random 1-100.
        
        actionLockCounter++;
        if(actionLockCounter==60){    
            if(Math.abs(distanceX)<(500) && Math.abs(distanceY)<(500)){
                if(i <= 75){
                    if(Math.abs(distanceX)>=Math.abs(distanceY)){
                        if(distanceX>=0){
                            direction="left";
                        }else{
                            direction="right";
                        }
                    }else{
                        if(distanceY>=0){
                            direction="up";
                        }else{
                            direction="down";
                        }
                    }
                }if(i > 75 && i <= 100){
                     mobShoot(worldx, worldy, direction);
                }            
                
        }else{ 
                //This tells NPC's what to do. 25% of the time it will do x. 
                if(i <= 25){
                    direction = "up";
                }
                if(i > 25 && i<= 50){
                    direction = "down";
                }
                if(i > 50 && i<= 75){
                    direction = "left";
                }
                if(i > 75 && i <= 100){
                    direction = "right";
                }
            
            }
            actionLockCounter=0;
        }
          
    }
}
