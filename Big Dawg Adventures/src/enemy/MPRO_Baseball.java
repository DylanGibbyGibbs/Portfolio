/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemy;

import java.util.Random;
import entity.entity;
import main.game_panel;
/**
 *
 * @author ltmer
 */
public class MPRO_Baseball extends entity {

    public MPRO_Baseball(game_panel gp, String fireDirection){
        super(gp);
        
        //Entity Stats
        direction = fireDirection;
        type = typeMProjectile;
        name = "Baseball";
        speed = 8;
        maxLife = 80;
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
       
        up1 = setup("/enemy/baseball");
        up2 = setup("/enemy/baseball");
        down1 = setup("/enemy/baseball");
        down2 = setup("/enemy/baseball"); 
        left1 = setup("/enemy/baseball");
        left2 = setup("/enemy/baseball"); 
        right1 = setup("/enemy/baseball");
        right2 = setup("/enemy/baseball"); 
    }

    //Projectile always moves in the direction the player is facing

    public void setAction(){
        
    }
}
