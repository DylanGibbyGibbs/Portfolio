
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.UtilityTool;
import main.game_panel;


//EXPERIMENT IF WE EVEN NEED TO HAVE THIS



//This is the super class of every object in the game. Keys, doors, etc
public class SuperObject {
    
    //Variables
    public BufferedImage image, image2, image3, image4, image5;
    public String name;
    public boolean collision = false;
    public int worldx;
    public int worldy;
    
    //Basically takes up a whole tile space. This can be changed by changing solid area within the specific object classes
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool utool = new UtilityTool();
    
    
    public void draw(Graphics2D g2d, game_panel gp)
    {
         int screenx = worldx - gp.myplayer.worldx + gp.myplayer.screenx; //where on the screen stuff will be drawn. 
            int screeny = worldy - gp.myplayer.worldy + gp.myplayer.screeny; // based upon these two coordinate values. 
            
            //basically if its not needing to be drawn, dont.
            if(worldx + gp.tile_size > gp.myplayer.worldx - gp.myplayer.screenx &&
               worldx - gp.tile_size < gp.myplayer.worldx + gp.myplayer.screenx && 
               worldy + gp.tile_size > gp.myplayer.worldy - gp.myplayer.screeny && 
               worldy - gp.tile_size < gp.myplayer.worldy + gp.myplayer.screeny)
            {
               g2d.drawImage(image, screenx, screeny, gp.tile_size, gp.tile_size, null); 
            }
    }
    
    
    
    
}
