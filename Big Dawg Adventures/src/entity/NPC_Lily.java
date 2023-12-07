
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
public class NPC_Lily extends entity{
    
    //Cool dog default constructor
    public NPC_Lily(game_panel gp)
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
       
        down1 = setup("/npc/lilydown1");
        down2 = setup("/npc/lilydown2");
        up1 = setup("/npc/lilyup1");
        up2 = setup("/npc/lilyup2");
       // right1 = setup("/npc/cooldogright1");
      //  right2 = setup("/npc/cooldogright2");
       // left1 = setup("/npc/cooldogleft1");
      //  left2 = setup("/npc/cooldogleft2");
    }
    
    
    public void setDialogue(){
        NPCdialogues[0] = "Hello! I'm lily";
        NPCdialogues[1] = "I saw a weird key to the \nbrick house southwest...";
        NPCdialogues[2] = "All these slimes and robots\n are making me nervous ;-;";
        NPCdialogues[3] = "There's an evil looking cat\n in the trash pit";
        NPCdialogues[4] = "I LEFT MY SNEAKERS AT THE ARCADE";
    }
    
    
    //Set the behaivior of lily.
    public void setAction()
    {
       actionLockCounter++;
      if(actionLockCounter == 180)
      {
      Random random = new Random();
   
        int i = random.nextInt(50)+1; //Random 1-100. 
        
        //This tells NPC's what to do. 25% of the time it will do x. 
        if(i <= 25)
        {
            direction = "up";
        }
        if(i > 25 && i<= 50)
        {
            direction = "down";
        }
      
        actionLockCounter = 0;
        
        
        
    }
  }
    public void speak(){
        
        if(NPCdialogues[dialogueIndex]==null){
            dialogueIndex=0;
        }
    gp.userInt.currentDialogue = NPCdialogues[dialogueIndex];
    dialogueIndex++;      
    }
    
    
}
