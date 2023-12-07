
package entity;

import java.awt.Graphics2D;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import main.UtilityTool;
import main.game_panel;

public class entity {
    
    //The game panel
    game_panel gp;
    
    //position and speed variables
    public int worldx;
    public int worldy;
    public int speed;
    
    //direction variables
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; 
    public String direction = "down";
    
    //Animation variables
    public int sprite_counter = 0;
    public int sprite_num = 1;
    
    //default entity area and x/y. This is important for having collision that works
    public Rectangle solidArea = new Rectangle(0,0,48,48); //Modify?
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    //default collision variable
    public boolean collisionOn = false; 
    
    //This is for basic ai movement
    public int actionLockCounter = 0;
    
    //misc
    String NPCdialogues[] = new String[20]; //NPC dialogue array
    int dialogueIndex = 0;
    
    //AI types
    //Currently tells us what does damage to what
    public int type;
    public int typeplayer = 0;
    public int typeNPC = 1;
    public int typeEnemy = 2;
    public int typeProjectile = 3;
    public int typeMProjectile = 4;
    
    //Entity Life Management
    public int maxLife;
    public int life;
    public boolean invincible;
    public int invincibleCounter;
    public boolean alive = true;
    public int damage;
    
    //Player attack variables
    public boolean attackPause;
    public int attackCounter;
    
    //Object Conversion to Entity
    public BufferedImage image, image2, image3, image4, image5;
    public String name;
    public boolean collision = false;
    
    int x;
    
    //constructor. Takes passed game panel and assigns it
    public entity(game_panel gp)
    {
        this.gp = gp;
    }
    
    
    
    //Reads images, scales them, and returns them to be placed
    public BufferedImage setup(String imagePath){
          
          
            UtilityTool utool = new UtilityTool();
            BufferedImage image = null;
            
            try
            {
                image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png")); //Read the sprite path
                image = utool.scaleImage(image, gp.tile_size, gp.tile_size);//Scale it up with the Utilitys
                
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return image;
        }
      
      
       
      
    public void draw(Graphics2D g2)
    {
            BufferedImage image = null;
       
            int screenx = worldx - gp.myplayer.worldx + gp.myplayer.screenx; //where on the screen stuff will be drawn. 
            int screeny = worldy - gp.myplayer.worldy + gp.myplayer.screeny; // based upon these two coordinate values. 
            
            //basically if its not needing to be drawn, dont.
            if(worldx + gp.tile_size > gp.myplayer.worldx - gp.myplayer.screenx &&
               worldx - gp.tile_size < gp.myplayer.worldx + gp.myplayer.screenx && 
               worldy + gp.tile_size > gp.myplayer.worldy - gp.myplayer.screeny && 
               worldy - gp.tile_size < gp.myplayer.worldy + gp.myplayer.screeny)
                {
             
                    
        //This Switch Case is the same as the player one       
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
                    
               //Draws stuff
               g2.drawImage(image, screenx, screeny, gp.tile_size, gp.tile_size, null); 
                } 
              
                
        
                
                
                
           
   }
    public void speak() 
    {
        //Keep this empty. This will be overided for each NPC
    }
    
    //Default AI behavior
    public void setAction()
    {
        Random random = new Random();
        int i = random.nextInt(100)+1; //Random 1-100. 
        
        //This tells NPC's what to do. 25% of the time it will do x. 
        if(i <= 25)
        {
            direction = "up";
        }
        if(i > 25 && i<= 50)
        {
            direction = "down";
        }
         if(i > 50 && i<= 75)
        {
            direction = "left";
        }
        if(i > 75 && i <= 100)
        {
            direction = "right";
        }
        
        
    }
    
    public void update()
    {
        //All of these call the checker function for collision. Basically turns on collision if anything collides that shouldn't. NPCS and Enemys Included
        setAction();
        collisionOn = false;
        gp.Checker.checkTile(this);
        gp.Checker.checkObject(this, false);
        gp.Checker.checkPlayer(this);
        gp.Checker.checkEntity(this,gp.npc);
        gp.Checker.checkEntity(this, gp.enemy);
        boolean contactPlayer = gp.Checker.checkPlayer(this);
       
        
        //If collision occurs. Damage the player. IF we add other damaging things put it here.
        if((this.type==typeEnemy ||this.type==typeMProjectile) && contactPlayer == true){
            if(gp.myplayer.invincible==false){
                gp.myplayer.life -=1;
                gp.myplayer.invincible = true;
            }
            if(this.type==typeMProjectile){
                this.alive=false;
            }
        }
        
        //Prevents Enemy Projectiles from getting stuck in enemys
        if(this.type==typeMProjectile && (gp.Checker.checkEntity(this,gp.enemy)!=999)){
            collisionOn = false;
        }
        
        //Prevents projectile from getting stuck on player
        if(this.type==typeProjectile && contactPlayer == true){
            collisionOn = false;
        }
        
        //This checks if projectile hits enemy, removes one life and kills projectile (null)
        if(this.type==typeProjectile && gp.Checker.checkEntity(this, gp.enemy) != 999){
            x = gp.Checker.checkEntity(this, gp.enemy);
            gp.enemy[gp.currentMap][x].life-=this.damage;
            this.damage=0;
            if("Shirt".equals(this.name)){this.alive = false;}
        }
        
        //This checks if a player projectile and an enemy projectile collide, and changes both to dead
        if(this.type==typeProjectile && gp.Checker.checkEntity(this, gp.mpro) != 999){
            x = gp.Checker.checkEntity(this, gp.mpro);
            gp.mpro[gp.currentMap][x].alive=false;
            this.damage=0;
            if("Shirt".equals(this.name)){this.alive = false;}
        }
        
        
        //Checks if life is 0, if life is zero alive is set to false
        if(this.life<=0){
            this.alive=false;
        }
    
    
           //if collision is false, the entity may move
       if(collisionOn == false) {
           
           switch(direction){
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
       }
       
       //We need to figure out a graceful way of handling collision. Its possible that npcs and characters can get stuck together. 
       //Probably take care of it here in some manner
       //else
      // {
           
     //  }
      
       
       //THIS CHANGES THE SPRITE TO MAKE ANIMATION
       sprite_counter++;
       
       if(sprite_counter > 7)
       {
           if(sprite_num == 1)
           {
               sprite_num = 2;
           }
           else if (sprite_num == 2)
           {
             sprite_num = 1;  
           }
           sprite_counter = 0;
       }

    
    }
    //Returns X distance for simple player tracking
    public int xDistance(){
        return this.worldx-gp.myplayer.worldx;
    }
    //Returns Y distance for simple player tracking
    public int yDistance(){
        return this.worldy-gp.myplayer.worldy;
    }
    public void mobShoot(int x, int y, String fireDirection){
        gp.asetter.setEnemyProj(x,y,fireDirection);
    }
}
