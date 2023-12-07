
package main;
import entity.entity;
import main.game_panel;
import tile.Tile_Manager;


public class CollisionChecker {

    private final game_panel gp;


    //makes the collision checker with this game panel
    public CollisionChecker(game_panel gp){
        this.gp = gp;
    }
    
    //Adds collision for every side for TILES
    public void checkTile(entity entity) {
    
        int entityLeftWorldX = entity.worldx + entity.solidArea.x;
        int entityRightWorldX = entity.worldx + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldy + entity.solidArea.y;
        int entityBottomWorldY = entity.worldy + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX/gp.tile_size;
        int entityRightCol = entityRightWorldX/gp.tile_size;
        int entityTopRow = entityTopWorldY/gp.tile_size;
        int entityBottomRow = entityBottomWorldY/gp.tile_size;
        
        int tileNum1, tileNum2;
        
        //Adds collision on every side of the tiles
        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tile_size;
                tileNum1 = gp.tm.map_array[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tm.map_array[gp.currentMap][entityRightCol][entityTopRow];
                if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                   entity.collisionOn = true;  
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tile_size;
                tileNum1 = gp.tm.map_array[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum2 = gp.tm.map_array[gp.currentMap][entityRightCol][entityBottomRow];
                if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                   entity.collisionOn = true;  
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tile_size;
                tileNum1 = gp.tm.map_array[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tm.map_array[gp.currentMap][entityLeftCol][entityBottomRow];
                if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                   entity.collisionOn = true;  
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tile_size;
                tileNum1 = gp.tm.map_array[gp.currentMap][entityRightCol][entityTopRow];
                tileNum2 = gp.tm.map_array[gp.currentMap][entityRightCol][entityBottomRow];
                if(gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true){
                   entity.collisionOn = true;  
                }
                break;
        }
    }
    
    //This deals with Collision for different objects. 
    public int checkObject(entity entity, boolean player){
        
        int index = 999;
        
        for(int i = 0; i <gp.obj[1].length; i++) {
            
            if(gp.obj[gp.currentMap][i] !=null){
                
                
                //get entitiy solid area position
                entity.solidArea.x = entity.worldx + entity.solidArea.x;
                entity.solidArea.y = entity.worldy + entity.solidArea.y;
                
                //get the objects solid area position
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].worldx + gp.obj[gp.currentMap][i].solidArea.x;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].worldy + gp.obj[gp.currentMap][i].solidArea.y;
                
                //This switch case makes sure collision is correct on all sides
                switch(entity.direction)  {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)){
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true) // Npcs are not affected by items. 
                            {
                                index = i;
                            }
                        }
                        break;
                        
                    case "down":
                        entity.solidArea.y += entity.speed;
                          if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)){
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true) // Npcs are not affected by items. 
                            {
                                index = i;
                            }
                        }
                        break;
                        
                    case "left":
                        entity.solidArea.x -= entity.speed;
                          if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)){
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true) // Npcs are not affected by items. 
                            {
                                index = i;
                            }
                        }
                        break;
                        
                    case "right":
                        entity.solidArea.y += entity.speed;
                          if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)){
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true) // Npcs are not affected by items. 
                            {
                                index = i;
                            }
                        
                        break;
                        }
            }
                
            
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
             gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
        }
        }
            return index;

    }
    
    //NPC and Enemy collision 
    public int checkEntity(entity entity, entity[][] target)
    {
      int index = 999;
        
        for(int i = 0; i <target[gp.currentMap].length; i++) {
            
            if(target[gp.currentMap][i] !=null){
                
                
                //get entitiy solid area position
                entity.solidArea.x = entity.worldx + entity.solidArea.x;
                entity.solidArea.y = entity.worldy + entity.solidArea.y;
                
                //get the objects solid area position
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].worldx + target[gp.currentMap][i].solidArea.x;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].worldy + target[gp.currentMap][i].solidArea.y;
                
                //This switch case makes sure collision is correct on all sides of tile
                switch(entity.direction)  {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                  
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                        
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                        
                    case "right":
                        entity.solidArea.y += entity.speed;
                        break;
            }
            
            if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea)){
                if(target[gp.currentMap][i] != entity){
                    entity.collisionOn = true;
                    index=i;
                }
            }
            
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
             target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
        }
        }
            return index;   
    }
    
    public boolean checkPlayer(entity entity){
        
        boolean contactPlayer = false;
        
        //get entitiy solid area position
                entity.solidArea.x = entity.worldx + entity.solidArea.x;
                entity.solidArea.y = entity.worldy + entity.solidArea.y;
                
                //get the objects solid area position
                gp.myplayer.solidArea.x = gp.myplayer.worldx + gp.myplayer.solidArea.x;
                gp.myplayer.solidArea.y = gp.myplayer.worldy + gp.myplayer.solidArea.y;
                
                //This switch case makes sure collision is correct on all sides of tile
                switch(entity.direction)  {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                        
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                        
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                        
                    case "right":
                        entity.solidArea.y += entity.speed;
                        break;
                        }
                
                
                          if(entity.solidArea.intersects(gp.myplayer.solidArea)){
                            entity.collisionOn = true;
                            contactPlayer=true;
                          
                        }
            
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.myplayer.solidArea.x = gp.myplayer.solidAreaDefaultX;
             gp.myplayer.solidArea.y = gp.myplayer.solidAreaDefaultY;
             
             return contactPlayer;
    }
    
}
