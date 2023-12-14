
package object;

import entity.entity;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.game_panel;

/**
 *
 * @author Gibby
 */
public class OBJ_Door extends entity
        {
    
    public OBJ_Door(game_panel gp)
    {
         super(gp);
        
        name = "Door";
        collision = true;
        down1 = setup("/objects/Door");
        
      
        
        
        
    }
    
}
