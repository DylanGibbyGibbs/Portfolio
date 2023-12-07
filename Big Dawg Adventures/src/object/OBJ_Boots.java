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
public class OBJ_Boots extends entity{
    
    public OBJ_Boots(game_panel gp)
    {
         super(gp);
        
      name = "Boots";
      down1 = setup("/objects/Sneaker"); //FIX
      
     
        
        
    }
    
}
