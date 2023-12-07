/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.UtilityTool;
import main.game_panel;
import main.keyboard_input;
import main.AssetSetter;
/**
 *
 * @author Gibby
 */
public class player extends entity{
    
    keyboard_input keyin;
    public int hasKey = 0;
    
    public final int screenx; //Screen position
    public final int screeny; 
    
    
    //creates the player and its keyboard input. 
    public player(game_panel gp, keyboard_input keyin)
    { 
        super(gp);
        
        this.keyin = keyin;
        screenx = gp.screen_width / 2 - gp.tile_size/2;
        screeny = gp.screen_height / 2 - gp.tile_size/2;
        
        //Added by JRans
        //Adds collision rules for player
        solidArea = new Rectangle();
        solidArea.x = 26;
        solidArea.y = 32;
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        
        solidArea.width = 16;
        solidArea.height = 16;
        
        set_default();
        get_player_sprite();
    }
    
    //This works because it is a child of entity
    public void set_default()
    {
        //Note: for dev room this may be the ticket to fixing things
        worldx=gp.tile_size * 12; // this is for the players position on world map
        worldy=gp.tile_size * 16;
        
        
        speed = 5; //JRans changed for speed runs around the map, change back to 4 when done
        direction = "down";
        
        
        //Player Life
        maxLife = 5;
        life = maxLife;
        
    }
    
    //Updates character position
    public void update(){
        //check if dead
        if(this.life<=0){
         gp.gameState = gp.dead;
        }
        
       if(keyin.up == true || keyin.down == true || keyin.left == true || keyin.right == true || keyin.shoot == true){
         if(keyin.up == true)
            {
            direction = "up";    
                
            }
        else if(keyin.down == true)
            {
            direction = "down";
                
            }
        else if(keyin.left == true)
            {
            direction = "left";
                
            }             
        else if(keyin.right == true)
            {
            direction = "right";
                
            }
         
         //Takes the shoot detection from key handler and begins projectile creation, and sets direction
         if(keyin.shoot == true){
            gp.projDirection = direction; //Assigns direction of projectile to the drection player was facing at the time of shooting
            gp.asetter.set_proj(worldx,worldy);//Gives Asset Setter current player position and summons the projectile
            keyin.shoot = false;
            attackPause = true;
        }
        
       //All of this checks for things that are interactable by the player specifically  
       //check tile Collision
       collisionOn = false;
       gp.Checker.checkTile(this);
       
       //check object collision
     int objIndex =  gp.Checker.checkObject(this, true);
       passive_interact(objIndex);
       
       //Check NPC collision
       int npcIndex = gp.Checker.checkEntity(this, gp.npc);
       interactNPC(npcIndex);
       
        //Check Enemy Collision
        int enemyIndex = gp.Checker.checkEntity(this, gp.enemy);
        contactEnemy(enemyIndex);
       
           //if collision is false, player can move
           if (collisionOn == false) {

               switch (direction) {
                   case "up":
                       worldy = worldy - speed;
                       break;
                   case "down":
                       worldy = worldy + speed;
                       break;
                   case "left":
                       worldx = worldx - speed;
                       break;
                   case "right":
                       worldx = worldx + speed;
                       break;
               }
               
           


        
        //Check Events
        gp.ehandler.checkEvent();
        
         gp.keyin.enter = false;

           //THIS CHANGES THE SPRITE TO MAKE ANIMATION
           sprite_counter++;

           if (sprite_counter > 7) {
               if (sprite_num == 1) {
                   sprite_num = 2;
               } else if (sprite_num == 2) {
                   sprite_num = 1;
               }
               sprite_counter = 0;
           }
       }    
       }
       
       //Checks for and handels Armor Types
       if(gp.armorSelect == 0){
           if(maxLife == 7 && life>5){
               if(life==6){
                   life =life-1;
               }else{
                   life = life-2;
               }
           }
           speed = 5;
           maxLife = 5;
       }if(gp.armorSelect==1){
           if(maxLife == 7 && life>5){
               if(life==6){
                   life =life-1;
               }else{
                   life = life-2;
               }
           }
           speed = 7;
           maxLife = 5;
       }if(gp.armorSelect==2){
           if(maxLife == 5){
               life = life+2;
           }
           speed = 5;
           maxLife=7;
       }
        //Counts invincible. Dont want to die instantly. We need a counter for invincibility frames
       if(invincible == true){
           invincibleCounter++;
           if(invincibleCounter>30){
           invincible=false;  
           invincibleCounter=0;
           }
    
       }
       
       //Counts Attack Pause
       if(attackPause == true){
           attackCounter++;
           if(attackCounter>30){
           attackPause=false;  
           attackCounter=0;
           }
    
       }
       
    }
    
    //This is the current method for interactables. It can currently deal with finding and using Keys for Doors. 
    public void passive_interact(int i) 
    {
        if(i != 999)
        {
            String objectName = gp.obj[gp.currentMap][i].name;
           
            
            switch(objectName){
                
                case "Key":
                    gp.playse(13);                         //play a bell
                    hasKey++;                               //number of keys you have goes up
                    gp.obj[gp.currentMap][i] = null;                       //deletes object just touched.
                    //System.out.println("You have:"+hasKey); //Testing purposes
                    break;
                    
                case "Door":
                    if(hasKey > 0)                              //If you have at least 1 key
                    {
                       gp.obj[gp.currentMap][i] = null;                        //deletes door just touched
                      // gp.playse(7);                          //plays a bonk
                       hasKey--; //number of keys goes down
                       gp.doorsOpen++;
                       //System.out.println("You have:"+hasKey);  //Testing Purpose
                      
                    }
                    break;
                case "tshirt_cannon":
                {
                     gp.playse(13);                         //play a bell
                    gp.obj[gp.currentMap][i] = null;   
                    gp.hasCannon = true;
                    break;
                }
                 case "Boxingglove":
                {
                     gp.playse(13);                         //play a bell
                    gp.obj[gp.currentMap][i] = null;   
                    gp.hasBoxing = true;
                    break;
                }
                 case "Helmet":
                {
                     gp.playse(13);                         //play a bell
                    gp.obj[gp.currentMap][i] = null;   
                    gp.hasHelmet = true;
                    break;
                }
                 case "Boots":
                {
                     gp.playse(13);                         //play a bell
                    gp.obj[gp.currentMap][i] = null;   
                    gp.hasBoots = true;
                    break;
                }
                
                
                
            }
            
        }
    }
    
    public void interactNPC(int i) //detects if touching NPC,  starts dialogue
    {
        if(i != 999){
            if(gp.keyin.enter == true){
                gp.gameState = gp.dialogue;
                gp.npc[gp.currentMap][i].speak();
            }
        }
       
    }
    
    public void contactEnemy(int i){ //detects if touching Enemy, gives damage
        if(i != 999){
            if(invincible==false){
                life=life-1;
                invincible = true;
            }
            
            }
        
     }
      
    
    //THIS CONTROLS ANIMATION BASED UPON SPRITE NUM AND DRAWING THE PLAYER IN GENERAL
    public void draw(Graphics2D g2)
    {
        
        //Nulls out the image to be drawn.
        BufferedImage image = null;
        
        switch(direction)
        {
            case "up":
                    if(sprite_num == 1)
                    {
                    image = up1;
                    }
                    if(sprite_num == 2)
                    {    
                    image = up2;
                    }
                    break;
                    
            case "down":
                    if(sprite_num == 1)
                    {
                    image = down1;
                    }
                     if(sprite_num == 2)
                     {
                     image = down2;    
                     }
                    break;
                    
            case "left":
                    if(sprite_num == 1)
                    {
                    image = left1;
                    }
                    if(sprite_num == 2)
                    {
                    image = left2;    
                    }
                    break;
                    
            case "right":
                    if(sprite_num == 1)
                    {
                    image = right1;
                    }
                    if(sprite_num == 2)
                    {
                    image = right2;    
                    }
                    break;
        }
        
        if (invincible == true){            
            g2.setColor(new Color(83, 1, 130));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));  
        }
        
        g2.drawImage(image, screenx, screeny,  null);   
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
    
    //Gives the corresponding sprite for direction
    public void get_player_sprite()
    {
       if(gp.weaponSelect == gp.tShirtCannon){
           
        up1 = setup("/player/tBack1");
        up2 = setup("/player/tBack2");
        down1 = setup("/player/tForward1");
        down2 = setup("/player/tForward2");
        right1 = setup("/player/tRight1");
        right2 = setup("/player/tRight2");
        left1 = setup("/player/tLeft1");
        left2 = setup("/player/tLeft2");
        
       }else if(gp.weaponSelect == gp.boxingGlove){
           
        up1 = setup("/player/pBack1");
        up2 = setup("/player/pBack2");
        down1 = setup("/player/pForward1");
        down2 = setup("/player/pForward2");
        right1 = setup("/player/pRight1");
        right2 = setup("/player/pRight2");
        left1 = setup("/player/pLeft1");
        left2 = setup("/player/pLeft2");     
    }else{
        up1 = setup("/player/back1");
        up2 = setup("/player/back2");
        down1 = setup("/player/forward1");
        down2 = setup("/player/forward2");
        right1 = setup("/player/right1");
        right2 = setup("/player/right2");
        left1 = setup("/player/left1");
        left2 = setup("/player/left2");
       }
    
    }
    
}
