 
package main;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tile.Tile_Manager;
/**
 *
 * @author Gibby
 */
public class game_panel extends JPanel implements Runnable{
    
    //Set screen size here
    public final int tile_size = 64;                                   //Default size for game tiles/sprites
    final int scale = 4;                                               //Scales up small sprites
    public final int row_ratio = 16;                                   //This is for a 16 by 9 aspect ratio
    public final int column_ratio = 9;                                 //NOTE THAT I THINK I HAVE THIS BACKWARDS
    public final int screen_width = tile_size * row_ratio;             //Calculates screen width
    public final int screen_height = tile_size * column_ratio;         //Calculates screen height
    
    //Maps and Sub Maps variables
    public final int maxMap = 10;
    public int currentMap = 1;
    
    //Gonna try to change how we do background music with this integer
    int currentbgm = 0;
    
    //Controls and draws current UI
    public user_interface userInt = new user_interface(this);       
    
    //This value controls the Frames per second (FPS)
    int fps = 60;
    
    //Keyboard Input Handling
    public keyboard_input keyin = new keyboard_input(this);
    
    //Tile Manager. Deals with ALL background tiles 
    Tile_Manager tm = new Tile_Manager(this);
    
    
    //Interactables: items. Change array number if we get a lot of items/npcs/enemys
    public AssetSetter asetter = new AssetSetter(this);
    public entity obj [][] = new entity[maxMap][10]; 
    public entity npc[][] = new entity[maxMap][10];
    public entity enemy[][] = new entity[maxMap][20];
    public entity pro[][] = new entity[maxMap][10];
    public entity mpro[][] = new entity[maxMap][20];
    ArrayList<entity> entityList = new ArrayList<>();
    
    
   
    
    //Event Handling
    public EventHandler ehandler = new EventHandler(this);
    
    //Weapon Selection
    public int weaponSelect = 0;
    public final int tShirtCannon = 1;
    public final int boxingGlove = 2;
    
    //Armor Selection
    public int armorSelect;
    public final int boots = 1;
    public final int helmet = 2;
    
    //World stuff. May need to switch these around based upon map size
    
    //9-24 THIS IS THE FINAL OVERWORLD SIZE!!!
    public final int maximum_world_columns = 50;
    public final int maximum_world_rows = 50;
    public final int world_width = tile_size * maximum_world_rows;
    public final int world_height = tile_size * maximum_world_columns;
    
    //Added by JRans
    //Call to collision checker
    public CollisionChecker Checker = new CollisionChecker(this);
    
    //Creates the player and takes keyboard input into account. 
    public player myplayer = new player(this, keyin);
    
    //Sound
    Sound sound = new Sound();
    Sound soundeffect = new Sound();
    
    
    
    //Sound State
    public int soundState;
    public final int soundOn=0;
    public final int soundOff=1;
    
    //Game States
    public int gameState;
    public final int title=0;       //title screen
    public final int play=1;        //game is running and active
    public final int pause=2;       //game is paused
    public final int settings=3;    //settings screen inside title screen
    public final int quit = 4;      //exit inside the title screen. 
    public final int dialogue = 5;
    public final int dead = 6;
    public final int control = 7;
    public final int win = 8;
    
    //Save Data
    Save save;
    public boolean hasBoxing;
    public boolean hasCannon;
    public boolean hasBoots;
    public boolean hasHelmet;
    public boolean hasKey1;
    public boolean hasKey2;
    public boolean hasKey3;
    public int doorsOpen;

   

    
    //The direction the player is facing the moment the projectile is fired
    public String projDirection;
    
    //Basically the thread is a startable and stoppable
    //Threads keep going like loops
    //Use it especially for game loops
    Thread game_thread;
    
    //Makes the game window
    public game_panel()
    {
        this.setPreferredSize(new Dimension(screen_width, screen_height));    //Set the size of the game window
        Color watercolor = new Color(88,164, 156);
        this.setBackground(watercolor);                                           //Set default background
        this.setDoubleBuffered(true);                                               //Supposed to improve rendering
        this.addKeyListener(keyin);                                                    //Makes taking in input possible
        this.setFocusable(true);                                                 //Game panel will focus on taking in the keys
    }
    
    
    
    
    //Sets all default game options and currently plays music when it starts
    public void gameSetup(){
        gameState=title;
        //currentbgm = 1;
        playbgm(9);
        soundState=soundOn;
        
        
        //Setting New Game save data (all false or 0)
        save = new Save(this);
        hasBoxing = false;
        hasCannon = false;
        hasBoots = false;
        hasHelmet = false;
        hasKey1 = false;
        hasKey2 = false;
        hasKey3 = false;
        doorsOpen = 0;
    }
    public void setEntities(){
 
        asetter.set_object();
        asetter.set_NPC();
        asetter.set_enemy();
}
    
    //starts the game loop
    public void startGameThread()
    {
        game_thread = new Thread(this);                                              //The this in this game thread makes it run all of the game panel stuff
        game_thread.start();                                                             //This starts the game thread until it is told to stop
        
    }
    
    //This is where the game loop happens. DONT CHANGE
    public void run()
    {
        double draw_interval = 1000000000/fps;                  //draw the screen every 1/60 of a second
        double next_draw = System.nanoTime() + draw_interval;   //the time to the next drawing of the screen in nano seconds
        
        while(game_thread != null)
        {
            
            //UPDATE: update screen information like character position.
            update();
            //DRAW:  draw the screen with that updated information. 
            repaint();
            
        try{
            double remaining_time = next_draw - System.nanoTime(); //remaining time to next draw time
            remaining_time = remaining_time/1000000;               //This converts from nano seconds to miliseconds               
            
            if(remaining_time < 0)
            {
                remaining_time = 0;
            }
            
            Thread.sleep((long) remaining_time);                   //dont update the screen or draw stuff for the remaining amount of time
            
            next_draw = next_draw + draw_interval;
            
           }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
            
            
        }
    }
    
    
    //This is responsible for Updating the locations of all things in our game. 
    public void update()
    {
       if(gameState == title){
           //nothing yet 
           
           
           
           
       }
       //In the Play state
       if(gameState == play){
           
           
           
           //update the player position
           myplayer.update();

           //update all of the npcs positions by going through the array
           for(int i = 0; i < npc[1].length; i++){
               if(npc[currentMap][i] != null){
                   npc[currentMap][i].update();
               }
           }
           
           //Update Enemys
           for(int i = 0; i < enemy[1].length; i++){
               if(enemy[currentMap][i] != null){
                   enemy[currentMap][i].update();
                   
                   if(enemy[currentMap][i].alive == false){
                       enemy[currentMap][i]=null;
                   }
               }
           }
           
           //Updates Projectile
           for(int i = 0; i < pro[1].length; i++){
               if(pro[currentMap][i] != null){
                   pro[currentMap][i].update();
                   pro[currentMap][i].life -= 1;
                   
                   if(pro[currentMap][i].alive==false){
                       pro[currentMap][i]=null;
                   }
               }
           }
           
           //Updates Enemy Projectile
           for(int i = 0; i < mpro[1].length; i++){
               if(mpro[currentMap][i] != null){
                   mpro[currentMap][i].update();
                   mpro[currentMap][i].life -= 1;
                   
                   if(mpro[currentMap][i].alive==false){
                       mpro[currentMap][i]=null;
                   }
               }
           }
           
           //Check for keys   (CHANGE IF YOU CHANGE THE LOCATION OF KEYS)     
           if(hasKey1 == false){
                if(obj[2][0]==null){
                    hasKey1 = true;
                }
            }
           
            if(hasKey2 == false){
                if(obj[3][0]==null){
                    hasKey2 = true;
                }
            }
        
            if(hasKey3 == false){
                if(obj[4][0]==null){
                    hasKey3 = true;
                }
            }
            
            //Check for win
            if(enemy[6][0]==null){
                gameState = win;
            }
       }
       
       if(gameState == pause){
           //nothing yet
           
          
           
       }
       if(gameState == settings){
           //nothing yet
           
       }
    }
    
    
    
    //This is responsible for painting the graphics
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
       
        
        
        //TITLE SCREEN
        if(gameState==title || gameState==settings){
            userInt.draw(g2);
        }else{
            
            //Background Tiles
             tm.draw(g2); // ALWAYS KEEP THIS ABOVE PLAYER! This is the background. The player must go ON TOP!
             
            //Add What is Considered an Entity
            
            //Player
            entityList.add(myplayer);
            
            //NPC
            for(int i = 0; i<npc[1].length; i++)
            {
                if(npc[currentMap][i] != null)
                {
                    entityList.add(npc[currentMap][i]);
                }
            }
            //Objects
            for(int i = 0; i<obj[1].length; i++)
            {
                if(obj[currentMap][i] != null)
                {
                    entityList.add(obj[currentMap][i]);
                }
            }
            //Enemys
            for(int i = 0; i<enemy[1].length; i++)
            {
                if(enemy[currentMap][i] != null)
                {
                    entityList.add(enemy[currentMap][i]);
                }
            }
            
            //Projectiles
            for(int i = 0; i<pro[currentMap].length; i++)
            {
                if(pro[currentMap][i] != null)
                {
                    entityList.add(pro[currentMap][i]);
                }
            }
           
            //enemy projectiles
            for(int i = 0; i<mpro[currentMap].length; i++)
            {
                if(mpro[currentMap][i] != null)
                {
                    entityList.add(mpro[currentMap][i]);
                }
            }
            
            //Sort Render Order
            Collections.sort(entityList, new Comparator<entity>() {
                 @Override
                 public int compare(entity e1, entity e2) {
                     
                    int result = Integer.compare(e1.worldy,e2.worldy);
                    return result;
                 }

            });
            
             //Draw all sorted entitys 
            for(int i=0; i< entityList.size(); i++)
            {
                entityList.get(i).draw(g2);
            }
            //Empty the entity list
             entityList.clear();
           
            
            //UI
            userInt.draw(g2);  
            
            
            
            
        }
      
        g2.dispose(); // Garbage collecting
        
    }
    
    
    //Fixes BGM issues caused by event Handler
    public void updatesounds()
    {
        playbgm(currentbgm);
    }
    
    //Plays background music
    public void playbgm(int i)
    {
        sound.setsoundfile(i);
        sound.play();
        sound.loop();
        soundState=soundOn;
    }
    //Stop the music
    public void stopsounds()
    {
        
        sound.stopsound();
        soundState=soundOff;
        
    }
    //play a sound effect
    public void playse(int i)
    {
        soundeffect.setsoundfile(i);
        soundeffect.play(); 
    }
}
