
package tile;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.UtilityTool;
import main.game_panel;

public class Tile_Manager 
{
    game_panel gp;

    public Tile[] tile;
    public int map_array[][][]; 
    
    //This will load the correct map and tiles
    public Tile_Manager(game_panel gp)
    {
      this.gp = gp;
      tile = new Tile[200];// change this when we need more tiles
      get_tilesprite();   // get the correct tiles to draw
      map_array = new int[gp.maxMap][gp.maximum_world_rows][gp.maximum_world_columns];
      
      
      load_map("/maps/gamemap.txt", 0);     //Gamemap 
      load_map("/maps/submap.txt", 1);      //Big Dawgs House
      load_map("/maps/dungeon.txt", 2);     //Dungeon
      load_map("/maps/pithouse.txt", 3);    //Brick House with Pit
      load_map("/maps/laundromat.txt", 4);  //Laundromat
      load_map("/maps/arcade.txt", 5);      //Arcade
      load_map("/maps/trasharena.txt", 6);  //Trash Arena
      load_map("/maps/screenhouse.txt", 7); //sceen house
      
      
      
      
     
    }
    
    //This will read from a map file
    public void load_map(String filepath, int map)
    {
       try
       {
        InputStream is = getClass().getResourceAsStream(filepath);            //load a map text file
        BufferedReader br = new BufferedReader(new InputStreamReader(is));      // reads the content of the text file
        
        int row = 0;
        int column = 0;
        while(row < gp.maximum_world_rows && column < gp.maximum_world_columns)
        {
            String line = br.readLine(); //read a line of the map text file
            
            while(row < gp.maximum_world_rows)
            {
                String number[] = line.split(" ");// Will split the line of text at spaces. This ensures that we get a singluar numbered tile
                int num = Integer.parseInt(number[row]);
                
                map_array[map][row][column] = num;
                row = row +1;
            }
            if(row == gp.maximum_world_rows) //basically go to next line
            {
                row = 0;
                column = column + 1; 
            }
        }
        br.close(); //close the text file reader
        
       }
       catch(Exception e)
       {
           
       }
        
        
        
    }
    
    //This holds all of the sprites and the collision info
    //On a text file just write out your map with the corresponding numbers
    public void get_tilesprite()
    {
        
            
            
            setup(0, "1", false);   //Grass
            setup(1, "10", false);   // Tall Grass Top Short Bottom
            setup(2, "100", false);  // Road Left
            setup(3, "101", false);  // Road Up
            setup(4, "102", false);  // Road Right
            setup(5, "103", false);  // Road Down
            setup(6, "104", false);  // Road Corner Top Left
            setup(7, "105", false);  // Road Corner Bottom Left
            setup(8, "106", false);  // Road Corner Bottom Right
            setup(9, "107", false);  // Road Corner Top Right     
            setup(10, "108", false); // Grey Brick Door
            setup(11, "109", true); // Grey Brick 1
            setup(12, "11", false);  // Tall Grass Bottom Short Top
            setup(13, "110", true); // Grey Brick 2
            setup(14, "111", true); // Grey Brick Roof Middle
            setup(15, "112", true); // Grey Brick Roof Left
            setup(16, "113", true); // Grey Brick Roof Right
            setup(17, "114", true); // Grey Brick Window
            setup(18, "115", false); // Grey Planks Up
            setup(19, "116", false); // Grey Plank Sides
            setup(20, "117", false); // Brick Door
            setup(21, "118", true); // Brick 1
            setup(22, "119", true); // Brick 2
            setup(23, "12", false);  // Tall Grass Right Short Left
            setup(24, "120", true); // Brick Roof Middle
            setup(25, "121", true);// Brick Roof Left Corner
            setup(26, "122", true); // Brick Roof Right
            setup(27, "123", true); // Brick Window
            setup(28, "124", false);// Sideways Wood
            setup(29, "125", false);// Up and Down Wood
            setup(30, "126", false); // Screen Door
            setup(31, "127", true); // White Siding
            setup(32, "128", true); // Siding Roof Middle
            setup(33, "129", true); // Rear Yaught
            setup(34, "13", false);  // Tall Grass left Short Right
            setup(35, "130", true); // Front Yaught
            setup(36, "131", false); // Middle Yaught         
            setup(37, "14", false);  // Top right grass circle
            setup(38, "15", false);  // Top Left Grass circle
            setup(39, "16", false);  // Bottom Left Grass Circle
            setup(40, "17", false);  // Bottom Right Grass circle
            setup(41, "18", true);  // Apple tree
            setup(42, "19", true); // Oak Tree 1
            setup(43, "2", false);   // Tall Grass Waluigi
            setup(44, "20", true);  // Oak Tree 2
            setup(45, "21", true);  // Peach Tree
            setup(46, "22", true);  // Pine Tree 1
            setup(47, "23", true);  // Pine Tree 2
            setup(48, "24", true);  // Pine Tree 3
            setup(49, "25", false);  // Tall Grass 1
            setup(50, "26", false);  // Tall Grass 2
            setup(51, "27", false);  // Tall Grass 3
            setup(52, "28", false);  // Tall Grass 4
            setup(53, "29", false);  // Grass Top Water Bottom
            setup(54, "3", false);   // L Tall Grass
            setup(55, "30", false);  // Grass Bottom Water Top
            setup(56, "31", false);  // Grass Right Water Left
            setup(57, "32", false);  // Grass Left Water Right
            setup(58, "33", false);  // R Grass Water Bottom Right
            setup(59, "34", false); // L Grass Water top right
            setup(60, "35", false); // Reverse L Grass Water top Left      
            setup(61, "36", false); // Waluigi Grass Water Bottom Left
            setup(62, "37", false); // R Water Grass Bottom Right 
            setup(63, "38", false); // L  Water Grass top right
            setup(64, "39", false); // Reverse L Water Grass top left
            setup(65, "4", false);  // Tall Grass Reverse L         
            setup(66, "40", false);  // Bottom Left Grass Corner
            setup(67, "41", false);  // Sand Right Water Left
            setup(68, "42", false);  // Sand Top Water Bottom
            setup(69, "43", false);  // Sand Left Water Right       
            setup(70, "44", false);  // Water on top, Sand On Bottom
            setup(71, "45", false);  // R Sand Water Bottom Right
            setup(72, "46", false);  // L Sand Water Top Right
            setup(73, "47", false);  // Reverse L Sand Water top left
            setup(74, "48", false);  // Waluigi Sand Water bottom left
            setup(75, "49", false);  // Bottom Left Sand Corner
            setup(76, "5", false);   // Waluigi Tall Grass
            setup(77, "50", false);  // Bottom Right Sand Corner
            setup(78, "51", false);  // Top Right Sand Corner
            setup(79, "52", false);  // Top Left Sand Corner
            setup(80, "53", true);  // Water        
            setup(81, "54", true);  // Rough Water 1
            setup(82, "55", true);  // Rough Water 2
            setup(83, "56", true);  // Rough Water 3
            setup(84, "57", true);  // Rough Water 4 
            setup(85, "58", false); // Sand 1
            setup(86, "59", false); // Sand 2
            setup(87, "6", false);  // Tall Grass Bottom Right Triangle
            setup(88, "60", false); // Sand 3
            setup(89, "61", false); // Sand 4
            setup(90, "62", false); // Conch Sand 
            setup(91, "63", true);  // Coconut on ground Palm Tree
            setup(92, "64", true);  // Coconut Palm Tree
            setup(93, "65", true);  // Palm Tree
            setup(94, "66", false); // Sand Bottom left Triangle
            setup(95, "67", false); // Sand Bottom right Triangle
            setup(96, "68", false); // Sand top Triangle             
            setup(97, "69", false); // Sand Top Left Triangle
            setup(98, "7", false);  // Bottom Right Tall Grass Triangle
            setup(99, "70", false); // Sand cicle top left
            setup(100, "71", false);// Sand cicle bottom left
            setup(101, "72", false);// Sand cicle bottom right
            setup(102, "73", false);// Sand cicle top right
            setup(103, "74", false);// Path left grass right
            setup(104, "75", false);// Path rigt grass left
            setup(105, "76", false);// Path top grass bottom
            setup(106, "77", false);// Path bottom grass top
            setup(107, "78", false);// Reverese L Path grass top left
            setup(108, "79", false);// Waluigi Path Grass bottom left
            setup(109, "8", false); // Triangle Tall Grass top left
            setup(110, "80", false);// R Path Grass bottom right
            setup(111, "81", false);// L path grass top right
            setup(112, "82", false);// path
            setup(113, "83", false);// Sidewalk right grass left
            setup(114, "84", false);// sidewalk top grass bottom
            setup(115, "85", false);// sidewalk left grass right
            setup(116, "86", false);// sidewalk bottom grass top
            setup(117, "87", false);// sidewalk reverse l
            setup(118, "88", false);// sidewalk waluigi
            setup(119, "89", false);// sidewalk r
            setup(120, "9", false); // triangle tall grass top right
            setup(121, "90", false);// sidewalk l
            setup(122, "91", false);// sidewalk
            setup(123, "92", false);// cracked sidewalk
            setup(124, "93", false);// Energy Drinks
            setup(125, "94", true); // Center Trash
            setup(126, "95", true); // Left Trash
            setup(127, "96", true); // Right Trash
            setup(128, "97", true); // overflowing trash
            setup(129, "98", true); // Hydrant
            setup(130, "99", true); // Leaking Hydrant
            setup(131, "a1", false); // Black
            setup(132, "a2", true); // Table
            setup(133, "a3", true); // Bed left
            setup(134, "a4", true); // Bed right
            setup(135, "a5", true); // Fridge
            setup(136, "a6", true); // Tv           
            setup(137, "a7", true); // Sink
            setup(138, "a8", true); // Toilet
            setup(139, "a9", true); // Oven 
            setup(140, "b1", false); // L pit
            setup(141, "b2", false); // Reverse L Pit
            setup(142, "b3", false); // Waluiji pit
            setup(143, "b4", false); // r pit
            setup(144, "b5", true); // Baseball machine
            setup(145, "b6", true); // Washing Machine     
            setup(146, "b7", true); // Dryer
            setup(147, "b8", false); // White
            setup(148, "b9", false); // Ladder
            setup(149, "c1", true); // chair
            setup(150, "c2", true); // chair
            setup(151, "c3", true); // table
            setup(152, "c4", true); // fireplace
            setup(153, "c5", true); // exhaust
            setup(154, "c6", true); // couch
            setup(155, "c7", true); // couch
            setup(156, "c8", true); // clock
            
             setup(157, "d1", false); // Arcade floor 1
             setup(158, "d2", false); // Arcade floor 2
             setup(159, "d3", false); // Arcade floor 3
             setup(160, "d4", false); // Arcade floor 4
             
             setup(161, "d5", true); // Pacman
             setup(162, "d6", true); // Galaga
             setup(163, "d7", true); // Street Skater
             setup(164, "d8", true); // Snake game
             setup(165, "d9", true); // Street fighter left
             setup(166, "e1", true); // Street fighter right
            
            
            
            
            
 
    }
    
    public void setup(int index, String imageName, boolean collision)
    {
        UtilityTool utool = new UtilityTool();
        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = utool.scaleImage(tile[index].image, gp.tile_size, gp.tile_size);
            tile[index].collision = collision;
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    //This draw function will draw the screen with all the tiles. Kinda in the same way a crt tv does. 
    public void draw(Graphics2D g2d)
    {
        
        
        int worldcolumn = 0;
        int worldrow = 0;
       
        
        while(worldcolumn < gp.maximum_world_columns && worldrow < gp.maximum_world_rows)
        {
            
            int tilenum = map_array[gp.currentMap][worldrow][worldcolumn];
            
            
            int worldx = worldrow * gp.tile_size;                            //world x coordinate on the map
            int worldy = worldcolumn * gp.tile_size;                         // world y coordinate
            int screenx = worldx - gp.myplayer.worldx + gp.myplayer.screenx; //where on the screen stuff will be drawn. 
            int screeny = worldy - gp.myplayer.worldy + gp.myplayer.screeny; // based upon these two coordinate values. 
            
            //basically if its not needing to be drawn, dont.
            if(worldx + gp.tile_size > gp.myplayer.worldx - gp.myplayer.screenx &&
               worldx - gp.tile_size < gp.myplayer.worldx + gp.myplayer.screenx && 
               worldy + gp.tile_size > gp.myplayer.worldy - gp.myplayer.screeny && 
               worldy - gp.tile_size < gp.myplayer.worldy + gp.myplayer.screeny)
            {
               g2d.drawImage(tile[tilenum].image, screenx, screeny, gp.tile_size, gp.tile_size, null); 
            }
            
            worldrow++;
           
            //Once you are done drawing the maximum row value restart
            if(worldrow == gp.maximum_world_rows)
            {
                worldrow = 0;
               
                worldcolumn ++;
               
            }
            
        }
        
        
    }
    
    
    
}
