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
public class MOB_Pitcher extends entity{
    int distanceY, distanceX;
    
    public MOB_Pitcher(game_panel gp, String fireDirection){
        super(gp);
     
        //indicates that it is an enenmy and not friendly
        type = typeEnemy; 
        
        //Stats
        name = "Pitcher";
        speed = 0;
        maxLife = 4;
        life = maxLife;
        alive = true;
        damage = 0;
        direction = fireDirection;
        
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
       
        down1 = setup("/Enemy/pitcherleft");
        down2 = setup("/Enemy/pitcherleft");
        up1 = setup("/Enemy/pitcherright");
        up2 = setup("/Enemy/pitcherright");
        right1 = setup("/Enemy/pitcherright");
        right2 = setup("/Enemy/pitcherright");
        left1 = setup("/Enemy/pitcherleft");
        left2 = setup("/Enemy/pitcherleft");
    }
    
    public void setAction()
    {
        distanceX = xDistance();
        distanceY = yDistance();
        
        if(Math.abs(distanceX)<(500) && Math.abs(distanceY)<(500)){
            actionLockCounter++;
            if(actionLockCounter == 90){
                    mobShoot(worldx, worldy, direction);
                    actionLockCounter = 0;
                }
            
        }
        
          
    }
}
