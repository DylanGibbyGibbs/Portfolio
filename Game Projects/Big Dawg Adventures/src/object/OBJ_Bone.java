package object;

import entity.entity;
import main.game_panel;

/**
 *
 * @author Gibby
 */
public class OBJ_Bone extends entity {
  
    
            
    public OBJ_Bone(game_panel gp)
    {
        super(gp);
           
          
        name = "Bone";
        image = setup("/objects/Fullbone");
        image2 = setup("/objects/3Qbone");
        image3 = setup("/objects/Halfbone");
        image4 = setup("/objects/Qbone");
        image5 = setup("/objects/Emptybone");    
                
        
        
    }
}

