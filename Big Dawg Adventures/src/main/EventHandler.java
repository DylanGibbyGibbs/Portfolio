package main;

import java.awt.Rectangle;

/**
 *
 * @author Gibby
 */
public class EventHandler {
    game_panel gp;
    
    
    
    EventRect eventRect [][][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    
    public EventHandler(game_panel gp) {
        this.gp = gp;
        
        eventRect = new EventRect[gp.maxMap][gp.maximum_world_columns][gp.maximum_world_rows];
        
        int map = 0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col < gp.maximum_world_columns && row < gp.maximum_world_rows)
        {
          //We need to mess with these to figure out the best collision
        eventRect[map][col][row] = new EventRect();    
        eventRect[map][col][row].x = 32;
        eventRect[map][col][row].y = 32;
        eventRect[map][col][row].width = 32;//pixels
        eventRect[map][col][row].height =64;//pixels
         eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
         eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;  
         
         col++;
         if(col == gp.maximum_world_columns)
         {
             col = 0;
             row++;
             
             if(row == gp.maximum_world_rows)
             {
                 row = 0;
                 map++;
             }
             
         }
        }
        
        
        
    }
    
    public void checkEvent()
    {
        
        
        //We want absolute values for distance from the previous events
         int xDistance = Math.abs(gp.myplayer.worldx - previousEventX); 
         int yDistance = Math.abs(gp.myplayer.worldy - previousEventY);
         
         int distance = Math.max(xDistance, yDistance); // Pick the larger of the two. 
         
         //Essentially, if there was a change in the x direction or the y direction, we are able to complete this event.
         if(distance > gp.tile_size) // We are more than 1 tile away from the last event
         {
             canTouchEvent = true;
         }
         
         
        if(canTouchEvent == true)
        {
        //This is for dealing with event tiles. There will be a lot. Format is x,y, direction to trigger it. followed by what it does. 
          
            
        //Dungeon Pitfalls damage and teleport 
        if(hit(2,19,17, "any") == true)  {  damagePit(14,17,gp.gameState); }
        if(hit(2,19,18, "any") == true)  {  damagePit(14,17,gp.gameState); }
        if(hit(2,20,17, "any") == true)  {  damagePit(14,17,gp.gameState); }
        if(hit(2,20,18, "any") == true)  {  damagePit(14,17,gp.gameState); }
        
        if(hit(2,32,16, "any") == true)  {  damagePit(14,17,gp.gameState); }
        if(hit(2,32,17, "any") == true)  {  damagePit(14,17,gp.gameState); }
        if(hit(2,33,16, "any") == true)  {  damagePit(14,17,gp.gameState); }
        if(hit(2,33,17, "any") == true)  {  damagePit(14,17,gp.gameState); }
        
        if(hit(3,30,17, "any") == true)  {  damagePit(22,22,gp.gameState); }
        if(hit(3,31,17, "any") == true)  {  damagePit(22,22,gp.gameState); }
        if(hit(3,30,16, "any") == true)  {  damagePit(22,22,gp.gameState); }
        if(hit(3,31,16, "any") == true)  {  damagePit(22,22,gp.gameState); }
        
        if(hit(7,25,27, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,26,27, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,25,26, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,26,26, "any") == true)  {  damagePit(24,27,gp.gameState); }
        
        if(hit(7,20,25, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,21,25, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,20,24, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,21,24, "any") == true)  {  damagePit(24,27,gp.gameState); }
        
        if(hit(7,29,25, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,30,25, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,29,24, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,30,24, "any") == true)  {  damagePit(24,27,gp.gameState); }
        
        if(hit(7,21,20, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,22,20, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,21,19, "any") == true)  {  damagePit(24,27,gp.gameState); }
        if(hit(7,22,19, "any") == true)  {  damagePit(24,27,gp.gameState); }
        
        //HEALING STATIONS    
        if(hit(1, 12,12, "any") == true)  {  healingFountain(gp.dialogue); }
        if(hit(3, 30,21, "any") == true)  {  healingFountain(gp.dialogue); }
        if(hit(4, 26,8, "any") == true)  {  healingFountain(gp.dialogue); }
        if(hit(7, 28,27, "any") == true)  {  healingFountain(gp.dialogue); }
        if(hit(7, 29,26, "any") == true)  {  healingFountain(gp.dialogue); }
       
            
        //Teleport Tiles    
        if(hit(0,28,46, "any") == true)  {  teleport_to(22, 2,gp.dialogue, "Thanks For Cruising With Cool Dawg"); }
        if(hit(0,22,1, "any") == true)  {   teleport_to(28, 47,gp.dialogue, "Thanks For Cruising With Cool Dawg"); }
        
        if(hit(4,29,22, "any") == true)  {  teleport_to(31, 11,gp.dialogue, "Going Up"); }
        if(hit(4,31,12, "any") == true)  {  teleport_to(29, 23,gp.dialogue, "Going Down"); }
        
        
        
        //Sub map switching
        
         //Big Dawgs House
         if(hit(0,31,33, "any") == true)  {   swapmaps(1, 12,17, gp.gameState); }
         if(hit(1,12,18, "any") == true)  {   swapmaps(0, 31,34, gp.gameState); }
         
         //Dungeon
         if(hit(0,21,24, "any") == true)  {   swapmaps(2, 13,18, gp.gameState); }
         if(hit(2,13,19, "any") == true)  {   swapmaps(0, 21,25, gp.gameState); }
         
         //Brick House with Pit
         if(hit(0,9,34, "any") == true)  {   swapmaps(3, 22,22, gp.gameState); }
         if(hit(3,22,23, "any") == true)  {   swapmaps(0, 9,35, gp.gameState); }
          
         
         //Laundromat
         if(hit(0,43,13, "any") == true)  {   swapmaps(4, 26,27, gp.gameState); }
         if(hit(4,26,28, "any") == true)  {   swapmaps(0, 43,14, gp.gameState); }
          
         
         //Arcade
         if(hit(0,39,7, "any") == true)  {   swapmaps(5, 32,24, gp.gameState); }
         if(hit(5,32,25, "any") == true)  {   swapmaps(0, 39,8, gp.gameState); }
            
         
         //Trash Pit

         if(hit(0,27,16, "any") == true)  {   swapmaps(6, 25,22, gp.gameState); }
        // if(hit(6,25,21, "any") == true)  {   swapmaps(0, 27,15, gp.gameState); }

         if(hit(0,27,14, "any") == true)  {   swapmaps(6, 25,22, gp.gameState); }
         if(hit(6,25,21, "any") == true)  {   swapmaps(0, 27,15, gp.gameState); }

         //Screen house
          if(hit(0,42,17, "any") == true)  {   swapmaps(7, 24,27, gp.gameState); }
          if(hit(7,24,28, "any") == true)  {   swapmaps(0, 42,18, gp.gameState); }
         
         
         
        }
        
    }
    
    //Checks collision
    public boolean hit(int map, int col, int row, String reqDirection)
    {
        boolean hit = false;
        
        if(map == gp.currentMap)
        {
        
            //Gets player solid position
            gp.myplayer.solidArea.x = gp.myplayer.worldx + gp.myplayer.solidAreaDefaultX;
            gp.myplayer.solidArea.y = gp.myplayer.worldy + gp.myplayer.solidAreaDefaultY;
            //Gets the event tile solid position
            eventRect[map][col][row].x = col*gp.tile_size + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row*gp.tile_size + eventRect[map][col][row].y;

            if(gp.myplayer.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false)
            {
                if(gp.myplayer.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) // This basically allows for collision events to be locked
                {                                                                                                // If we want something to happen only when player is going left
                    hit = true;                                                                                  // on a given tile, it can be done gracefully.
                    previousEventX = gp.myplayer.worldx;
                    previousEventY = gp.myplayer.worldy;
                }
            }
            //Reset
            gp.myplayer.solidArea.x = gp.myplayer.solidAreaDefaultX;
            gp.myplayer.solidArea.y = gp.myplayer.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;

        }   
        
        return hit;
    }
    
    public void damagePit(int col, int row, int gameState)
    {
       
        
       
        gp.myplayer.life -= 1;
       // eventRect[col][row].eventDone = true; //We may wanna create a class for permanant and temporary damage tiles
        canTouchEvent = true;
         gp.myplayer.worldx = gp.tile_size *  col;
         gp.myplayer.worldy = gp.tile_size * row;
        
        
    }
    
    public void healingFountain(int gameState)
    {
        if(gp.keyin.enter == true) //Check for enter
        {    
        gp.gameState = gp.dialogue;  //Sets game to a dialogue state
        
        gp.userInt.currentDialogue = "Delicious"; //add dialogue
        gp.myplayer.life = gp.myplayer.maxLife; //do something
        
        }
      
    }
    
    public void teleport_to(int col, int row, int gameState, String message)
    {
          
        gp.gameState = gp.dialogue;  //Sets game to a dialogue state
        
        gp.userInt.currentDialogue = message; //add dialogue
        gp.myplayer.worldx = gp.tile_size *  col;
        gp.myplayer.worldy = gp.tile_size * row;
        
      
    }
    
    public void swapmaps(int map, int col, int row, int gameState)
    {
        //To make this work as well as it can we need to make sure that the map number and the associated music match. This way we can set the current background music to its associated map
        gp.currentMap = map;
        gp.currentbgm = map;
        gp.stopsounds();
        gp.myplayer.worldx = gp.tile_size * col;
        gp.myplayer.worldy = gp.tile_size * row;
        gp.playse(13);
        gp.updatesounds();
    }

    
    
    
}
