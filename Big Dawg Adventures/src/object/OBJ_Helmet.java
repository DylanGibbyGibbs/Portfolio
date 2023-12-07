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
public class OBJ_Helmet extends entity {
    
    public OBJ_Helmet(game_panel gp)
    {
         super(gp);
        
      name = "Helmet";
      down1 = setup("/objects/helmet-1"); //FIX
      
     
        
        
    }
    
    
}
