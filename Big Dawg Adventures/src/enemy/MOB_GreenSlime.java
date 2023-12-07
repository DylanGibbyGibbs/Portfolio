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
public class MOB_GreenSlime extends entity{
    int distanceY, distanceX;
    public MOB_GreenSlime(game_panel gp){
        super(gp);
        
        //indicates that it is an enenmy and not friendly
        type = typeEnemy; 
        
        //Stats
        name = "Green Slime";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        alive = true;
        
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
       
        down1 = setup("/Enemy/greenslime_0");
        down2 = setup("/Enemy/greenslime_2");
        up1 = setup("/Enemy/greenslime_5");
        up2 = setup("/Enemy/greenslime_6");
        right1 = setup("/Enemy/greenslime_0");
        right2 = setup("/Enemy/greenslime_2");
        left1 = setup("/Enemy/greenslime_5");
        left2 = setup("/Enemy/greenslime_6");
    }
    
    @Override
    public void setAction()
    {
        distanceX = xDistance();
        distanceY = yDistance();
        
        actionLockCounter++;
        if(actionLockCounter == 30){
        if(Math.abs(distanceX)<(320) && Math.abs(distanceY)<(320)){
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
        }else{ 
            
          
                Random random = new Random();
   
                int i = random.nextInt(100)+1; //Random 1-100. 
        
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
        actionLockCounter = 0;
        }
    }
}
