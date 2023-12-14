
package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import main.UtilityTool;
import main.game_panel;

/**
 *
 * @author Gibby
 */
public class NPC_CoolDog extends entity{
    
    //Cool dog default constructor
    public NPC_CoolDog(game_panel gp)
    {
        super(gp);
        direction = "up";
        speed = 1;
        get_sprite();  
        setDialogue();
    }
    
    //Defines the path to get the npc sprite.
    public void get_sprite()
    {
       
        down1 = setup("/npc/cooldogdown1");
        down2 = setup("/npc/cooldogdown2");
        up1 = setup("/npc/cooldogup1");
        up2 = setup("/npc/cooldogup2");
        right1 = setup("/npc/cooldogright1");
        right2 = setup("/npc/cooldogright2");
        left1 = setup("/npc/cooldogleft1");
        left2 = setup("/npc/cooldogleft2");
    }
    
    public void setDialogue(){
        NPCdialogues[0] = "I'M COOL DOG";
        NPCdialogues[1] = "Someone left a key at the \nlaundry mat";
        NPCdialogues[2] = "Yeah, I know... I'm pretty cool";
        NPCdialogues[3] = "There was another key \nin the pitchers room";
        NPCdialogues[4] = "These robots are harshing \nmy vibe";
    }
    //Set the behaivior of Cooldog.
    public void setAction()
    {
       actionLockCounter++;
      if(actionLockCounter == 120)
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
   //     Try to implement stopping here
   //     if(i > 100 && i <= 125)
   //     {
   //         direction = "stop";
    //        System.out.println("stop");
    //    }
        actionLockCounter = 0;
        
        
        
    }
  }
 
    public void speak(){
        
        //Resets dialogue if you cycle through all options
        if(NPCdialogues[dialogueIndex]==null){
            dialogueIndex=0;
        }
        //Passes this to the user interface
    gp.userInt.currentDialogue = NPCdialogues[dialogueIndex];
    dialogueIndex++;    
    
    }
}
    
