/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import entity.entity;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.game_panel;
/**
 *
 * @author Gibby
 */
public class OBJ_Tshirtcannon extends entity{
    
       public OBJ_Tshirtcannon(game_panel gp)
    {
         super(gp);
        
      name = "tshirt_cannon";
      down1 = setup("/objects/tshirt_cannon");
      
     
        
        
    }
    
}
