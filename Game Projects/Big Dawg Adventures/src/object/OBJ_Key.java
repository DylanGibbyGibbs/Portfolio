
package object;

import entity.entity;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.game_panel;

/**
 *
 * @author Gibby
 */
public class OBJ_Key extends entity
        {
   
            
    public OBJ_Key(game_panel gp)
    {
         super(gp);
        
      name = "Key";
      down1 = setup("/objects/Key");
      
     
        
        
    }
}
