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
public class MOB_EvilCat extends entity{
    int distanceY, distanceX;
    public MOB_EvilCat(game_panel gp){
        super(gp);
        
        //indicates that it is an enenmy and not friendly
        type = typeEnemy; 
        
        //Stats
        name = "Evil Cat";
        speed = 3;
        maxLife = 10;
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
       
        down1 = setup("/Enemy/evilcat1");
        down2 = setup("/Enemy/evilcat2");
        up1 = setup("/Enemy/evilcat1");
        up2 = setup("/Enemy/evilcat2");
        right1 = setup("/Enemy/evilcat1");
        right2 = setup("/Enemy/evilcat2");
        left1 = setup("/Enemy/evilcat1");
        left2 = setup("/Enemy/evilcat2");
    }
    
    @Override
    public void setAction()
    {
        distanceX = xDistance();
        distanceY = yDistance();
        
        actionLockCounter++;
        if(actionLockCounter == 30){
            
            Random random = new Random();
            int i = random.nextInt(100)+1;
                
            if(Math.abs(distanceX)<(320) && Math.abs(distanceY)<(320)){
                if(i<=50){
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
                }
                if(i > 50 && i<= 75){
                    mobShoot(worldx,worldy,"up");
                    mobShoot(worldx,worldy,"down");
                    mobShoot(worldx,worldy,"left");
                    mobShoot(worldx,worldy,"right");
                }
                if(i > 75 && i<= 90){
                    mobShoot(worldx,worldy,direction);
                }
                if(i > 75 && i <= 100){
                    if(direction=="left" || direction =="right"){
                        mobShoot(worldx,worldy+64,direction);
                        mobShoot(worldx,worldy,direction);
                        mobShoot(worldx,worldy-64,direction);
                    }else{
                        mobShoot(worldx+64,worldy,direction);
                        mobShoot(worldx,worldy,direction);
                        mobShoot(worldx-64,worldy,direction);
                    }
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
            actionLockCounter = 0;
        }
    }
}
