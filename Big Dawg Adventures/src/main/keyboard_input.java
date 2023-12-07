
package main;

import java.awt.event.*;
/**
 *
 * @author Gibby
 */
public class keyboard_input implements KeyListener
{
    //Variables for movement
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean shoot;
    public boolean still; //Consider changing if you cant get ai to stay still
    public boolean enter;
    public boolean pausemusic = true; //Consider Changing
    
    
    game_panel gp;
            
    //Construtor to communicate current game state
    public keyboard_input(game_panel gp){
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
       //NOTHING HERE YET 
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int getkey = e.getKeyCode();        //Returns number of the key that was pressed
        
        //Play State
        if(gp.gameState==gp.play){
            if(getkey == KeyEvent.VK_W){
                up = true;
            }
            if(getkey == KeyEvent.VK_S){
                down = true;
            }
            if(getkey == KeyEvent.VK_A){
                left = true;
            }
            if(getkey == KeyEvent.VK_D){
                right = true;
            }
            if(getkey == KeyEvent.VK_SPACE && gp.myplayer.attackPause==false){
                
                shoot = true; 
                
                
                
                //Play this sf if player has cannon
                if(gp.weaponSelect == gp.tShirtCannon)
                {
                gp.playse(14);
                }
                //Play this sf if player has cannon
                if(gp.weaponSelect == gp.boxingGlove)
                {
                gp.playse(15);
                }

            }
            if(getkey == KeyEvent.VK_ENTER){
                enter = true;
            }
            if(getkey == KeyEvent.VK_P){
                gp.gameState = gp.pause;
                //Play the Music for the pause menu but dont set that as the current bgm
                gp.stopsounds();
                gp.playbgm(10);  
            }
            
            
            
        }
        //Title State
        if(gp.gameState == gp.title){
            if(getkey == KeyEvent.VK_W){ //up in title menu
                gp.userInt.commandNum--; 
                if(gp.userInt.commandNum<0){
                    gp.userInt.commandNum=3;//wraps selected title screen option to bottom
                }
            }
            if(getkey == KeyEvent.VK_S){//down in title menu
                gp.userInt.commandNum++;
                if(gp.userInt.commandNum>3){
                    gp.userInt.commandNum=0;//wraps selected title screen option to top
                }
            }
            if(getkey == KeyEvent.VK_ENTER){ //select in title screen
                if(gp.userInt.commandNum==0){
                    gp.save.LoadNewGame();
                    gp.setEntities();
                    gp.gameState = gp.play; //lets you start the game
                    gp.stopsounds();
                    gp.currentbgm=0;
                    gp.playbgm(gp.currentbgm);       
                     
                }else if(gp.userInt.commandNum==1){
                    if(gp.save.LoadSave()){
                        gp.setEntities();
                        gp.stopsounds();
                        gp.playbgm(gp.currentbgm);
                        gp.myplayer.get_player_sprite();
                        gp.gameState = gp.play;
                    }                     
                }else if(gp.userInt.commandNum==2){
                    gp.userInt.commandNum=-1;
                    gp.gameState=gp.settings;     //goes to the setting menu
                }else if(gp.userInt.commandNum==3){
                    System.exit(0);
                }
            }
        }
         
         
        //Settings State
        if(gp.gameState == gp.settings){
            if(getkey == KeyEvent.VK_W){ //up
                gp.userInt.commandNum--; 
                if(gp.userInt.commandNum<0){
                    gp.userInt.commandNum=2;//wraps selected title screen option to bottom
                }
            }
            if(getkey == KeyEvent.VK_S){//down
                gp.userInt.commandNum++;
                if(gp.userInt.commandNum>2){
                    gp.userInt.commandNum=0;//wraps selected title screen option to top
                }
            }
            if(getkey == KeyEvent.VK_ENTER){ //select
                if(gp.userInt.commandNum == 0){
                    gp.gameState = gp.control;
                }
                if(gp.userInt.commandNum==1){
                    if(gp.soundState==gp.soundOn){//toggles sound
                        gp.stopsounds();
                    }else{
                        //gp.currentbgm = ;
                        gp.playbgm(4);
                    }
                     
                }
                if(gp.userInt.commandNum==2){
                    gp.gameState=gp.title;
                    gp.userInt.commandNum=0;
                }
            }
        }
        if(gp.gameState == gp.control){
            if(getkey == KeyEvent.VK_SPACE){
                gp.gameState = gp.settings;
            }
        }
         
        //Pause State
        if(gp.gameState == gp.pause){
            
                 
             
            if(getkey == KeyEvent.VK_W){ //up in title menu
                gp.userInt.commandNum--; 
                if(gp.userInt.commandNum<0){
                    gp.userInt.commandNum=4;//wraps selected title screen option to bottom
                }
            }
             
            if(getkey == KeyEvent.VK_S){//down in menu
                gp.userInt.commandNum++;
                if(gp.userInt.commandNum>4){
                    gp.userInt.commandNum=0;//wraps selected title screen option to top
                }
            }
            if(getkey == KeyEvent.VK_A){
                if(gp.userInt.commandNum==0){
                  /*  gp.weaponSelect = gp.weaponSelect-1;
                    if(gp.weaponSelect < 0){
                        
                        gp.weaponSelect = 2;
                    }*/
                    
                    if(gp.weaponSelect == 0 && gp.hasBoxing == true){
                        gp.weaponSelect = gp.boxingGlove;
                    }else if(gp.weaponSelect == 0 && gp.hasCannon == true){
                        gp.weaponSelect = gp.tShirtCannon;
                    }else if(gp.weaponSelect == gp.tShirtCannon){
                        gp.weaponSelect = 0;
                    }else if(gp.weaponSelect == gp.boxingGlove && gp.hasCannon == true){
                        gp.weaponSelect = gp.tShirtCannon;
                    }else if(gp.weaponSelect == gp.boxingGlove){
                        gp.weaponSelect=0;
                    }
                   
                   gp.myplayer.get_player_sprite();
                   
                }else if(gp.userInt.commandNum==1){
                    if(gp.armorSelect == 0 && gp.hasHelmet == true){
                        gp.armorSelect = gp.helmet;
                    }else if(gp.armorSelect == 0 && gp.hasBoots == true){
                        gp.armorSelect = gp.boots;
                    }else if(gp.armorSelect == gp.boots){
                        gp.armorSelect = 0;
                    }else if(gp.armorSelect == gp.helmet && gp.hasBoots == true){
                        gp.armorSelect = gp.boots;
                    }else if(gp.armorSelect == gp.helmet){
                        gp.weaponSelect=0;
                    }
                }
            }
            
            if(getkey == KeyEvent.VK_D){
                if(gp.userInt.commandNum==0){
                    
                    if(gp.weaponSelect == 0 && gp.hasCannon == true){
                    gp.weaponSelect = gp.tShirtCannon;
                    }else if(gp.weaponSelect == 0 && gp.hasBoxing == true){
                        gp.weaponSelect = gp.boxingGlove;
                    }else if(gp.weaponSelect == gp.tShirtCannon && gp.hasBoxing ==  true){
                        gp.weaponSelect = gp.boxingGlove;
                    }else if(gp.weaponSelect == gp.tShirtCannon){
                        gp.weaponSelect = 0;
                    }else if(gp.weaponSelect == gp.boxingGlove){
                        gp.weaponSelect = 0;
                    }
                    gp.myplayer.get_player_sprite();
                
                }else if(gp.userInt.commandNum == 1){
                    if(gp.armorSelect == 0 && gp.hasBoots == true){
                    gp.armorSelect = gp.boots;
                    }else if(gp.armorSelect == 0 && gp.hasHelmet == true){
                        gp.armorSelect = gp.helmet;
                    }else if(gp.armorSelect == gp.boots && gp.hasHelmet ==  true){
                        gp.armorSelect = gp.helmet;
                    }else if(gp.armorSelect == gp.boots){
                        gp.armorSelect = 0;
                    }else if(gp.armorSelect == gp.helmet){
                        gp.armorSelect = 0;
                    }
                }
            }
            if(getkey == KeyEvent.VK_ENTER){
                if(gp.userInt.commandNum==0){ //This is for weapon
                   
                }
                else if(gp.userInt.commandNum==1){// This is for Armor
                         
                          
                }else if(gp.userInt.commandNum==2){//Continue Game
                    gp.gameState = gp.play;
                    gp.stopsounds(); //stop what the current background music is
                  
                    gp.playbgm(gp.currentbgm); //play the current background music agian
                   
                }else if(gp.userInt.commandNum==3){//Go back to title
                    gp.save.CreateSave();
                    gp.save.SaveGame();
                     
                }else if(gp.userInt.commandNum==4){//Quit game
                    System.exit(0);
                }
            }
            
        }
         
         //Dialogue State
        if(gp.gameState == gp.dialogue){
             
            if(getkey == KeyEvent.VK_W || getkey == KeyEvent.VK_A || getkey == KeyEvent.VK_S || getkey == KeyEvent.VK_D || getkey == KeyEvent.VK_SPACE ){
                gp.gameState = gp.play;                
            }
        }
        
        //Dead State
        if(gp.gameState == gp.dead){
            if(getkey == KeyEvent.VK_W){ //up
                gp.userInt.commandNum--; 
                if(gp.userInt.commandNum<0){
                    gp.userInt.commandNum=1;//wraps selected title screen option to bottom
                }
            }
            if(getkey == KeyEvent.VK_S){//down
                gp.userInt.commandNum++;
                if(gp.userInt.commandNum>1){
                    gp.userInt.commandNum=0;//wraps selected title screen option to top
                }
            }
            if(getkey == KeyEvent.VK_ENTER){//down
                if(gp.userInt.commandNum == 0){
                    gp.gameState=gp.title;
                }if(gp.userInt.commandNum == 1){
                    System.exit(0);
                }
            }
        }
        
        //WIN State
        if(gp.gameState == gp.win){
            if(getkey == KeyEvent.VK_W){ //up
                gp.userInt.commandNum--; 
                if(gp.userInt.commandNum<0){
                    gp.userInt.commandNum=1;//wraps selected title screen option to bottom
                }
            }
            if(getkey == KeyEvent.VK_S){//down
                gp.userInt.commandNum++;
                if(gp.userInt.commandNum>1){
                    gp.userInt.commandNum=0;//wraps selected title screen option to top
                }
            }
            if(getkey == KeyEvent.VK_ENTER){//down
                if(gp.userInt.commandNum == 0){
                    gp.gameState=gp.title;
                }if(gp.userInt.commandNum == 1){
                    System.exit(0);
                }
            }
        }
         
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int getkey = e.getKeyCode();        //Returns number of the key that was pressed
        
        if(getkey == KeyEvent.VK_W)
        {
            up = false;

        }
        if(getkey == KeyEvent.VK_S)
        {
            down = false;

        }
        if(getkey == KeyEvent.VK_A)
        {
            left = false;

        }
        if(getkey == KeyEvent.VK_D)
        {
            right = false;

        }if(getkey == KeyEvent.VK_SPACE)
        {
           // shoot = false;
           // WALKING BUG WHEN SHOOTING IF IMPLEMENTED HERE, IMPLEMENTED IN PLAYER CLASS TEMPORARILY
        }
        
    }
    
    
}
