
package main;

import entity.NPC_CoolDog;
import entity.NPC_Lily;
import entity.PRO_Shirt;
import entity.PRO_Punch;



import enemy.MOB_GreenSlime;
import enemy.MOB_RedSlime;
import enemy.MOB_Pitcher;
import enemy.MOB_Cyborg;
import enemy.MOB_EvilCat;

import enemy.MPRO_Baseball;

import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Boots;
import object.OBJ_Boxingglove;
import object.OBJ_Helmet;
import object.OBJ_Tshirtcannon;
/**
 *
 * @author Gibby
 */
public class AssetSetter {
    game_panel gp;
   // int mapNum = 0;
    
    
    public AssetSetter(game_panel gp)
    {
        this.gp = gp;
    }
    
    // This command sets any power ups, keys, or locked doors
    public void set_object()
    {
        
        //Game Map. 3 locked doors and the punching bag
        int mapNum = 0;
        if(gp.doorsOpen < 1){
            gp.obj[mapNum][0] = new OBJ_Door(gp);
            gp.obj[mapNum][0].worldx = 25 * gp.tile_size;
            gp.obj[mapNum][0].worldy = 15 * gp.tile_size;
        }
        
        if(gp.doorsOpen <=1 ){
            gp.obj[mapNum][1] = new OBJ_Door(gp);
            gp.obj[mapNum][1].worldx = 26 * gp.tile_size;
            gp.obj[mapNum][1].worldy = 15 * gp.tile_size;
        }
        
        if(gp.doorsOpen <=2 ){
            gp.obj[mapNum][2] = new OBJ_Door(gp);
            gp.obj[mapNum][2].worldx = 27 * gp.tile_size;
            gp.obj[mapNum][2].worldy = 15 * gp.tile_size;
        }
        
        if(gp.hasBoxing == false){
            gp.obj[mapNum][3] = new OBJ_Boxingglove(gp);
            gp.obj[mapNum][3].worldx = 35 * gp.tile_size;
            gp.obj[mapNum][3].worldy = 46 * gp.tile_size;
        }
        
        //Big Dawgs house. Just a helmet
        mapNum = 1;
        if(gp.hasHelmet==false){
            gp.obj[mapNum][0] = new OBJ_Helmet(gp);
            gp.obj[mapNum][0].worldx = 20 * gp.tile_size;
            gp.obj[mapNum][0].worldy = 17 * gp.tile_size;
        }
        
        //The dungeon 1 find 1 key  (IF ALTERED CHANGE KEY LOCATION IN GAMEPANEL.UPDATE)
        mapNum = 2;
        if(gp.hasKey1 == false){//checks to see if player has already picked up key (for save data)
            gp.obj[mapNum][0] = new OBJ_Key(gp);
            gp.obj[mapNum][0].worldx = 37 * gp.tile_size;
            gp.obj[mapNum][0].worldy = 15 * gp.tile_size;
        }
        
        //The brick house with the pit find another key? (IF ALTERED CHANGE KEY LOCATION IN GAMEPANEL.UPDATE)
        mapNum = 3;
        if(gp.hasKey2 == false){//checks to see if player has already picked up key (for save data)
            gp.obj[mapNum][0] = new OBJ_Key(gp);
            gp.obj[mapNum][0].worldx = 27 * gp.tile_size;
            gp.obj[mapNum][0].worldy = 16 * gp.tile_size;
        }
        //Laundromat (IF ALTERED CHANGE KEY LOCATION IN GAMEPANEL.UPDATE)
        mapNum = 4; 
        if(gp.hasKey3 == false){//checks to see if player has already picked up key (for save data)
            gp.obj[mapNum][0] = new OBJ_Key(gp);
            gp.obj[mapNum][0].worldx = 25 * gp.tile_size;
            gp.obj[mapNum][0].worldy = 12 * gp.tile_size;
        }
      
        //Arcade. Speed boots
        mapNum = 5;
     
        if(gp.hasBoots == false){
            gp.obj[mapNum][0] = new OBJ_Boots(gp);
            gp.obj[mapNum][0].worldx = 20 * gp.tile_size;
            gp.obj[mapNum][0].worldy = 19 * gp.tile_size;
        }
        
        //Screen house dungeon. Final key
        mapNum = 7;
        if(gp.hasCannon == false){
            gp.obj[mapNum][1] = new OBJ_Tshirtcannon(gp);
            gp.obj[mapNum][1].worldx = 19 * gp.tile_size;
            gp.obj[mapNum][1].worldy = 19 * gp.tile_size;
        }
        
    }
    
    
    public void set_NPC()
    {
        
        int mapNum = 0; //change the map num for where the entitiys will go. 
       gp.npc[mapNum][0] = new NPC_CoolDog(gp);
       gp.npc[mapNum][0].worldx = gp.tile_size * 27;
       gp.npc[mapNum][0].worldy = gp.tile_size * 47;
       
       gp.npc[mapNum][1] = new NPC_Lily(gp);
       gp.npc[mapNum][1].worldx = gp.tile_size * 32;
       gp.npc[mapNum][1].worldy = gp.tile_size * 26;
       
       mapNum = 1;//anything set under this will go in Big Dawgs House
       
       
       
       
       
    }
    
    public void set_enemy(){
        
        int mapNum = 0;
        gp.enemy[mapNum][0] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][0].worldx = gp.tile_size*45;
        gp.enemy[mapNum][0].worldy = gp.tile_size*44;
        
        gp.enemy[mapNum][1] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][1].worldx = gp.tile_size*44;
        gp.enemy[mapNum][1].worldy = gp.tile_size*44;
        
        gp.enemy[mapNum][2] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][2].worldx = gp.tile_size*20;
        gp.enemy[mapNum][2].worldy = gp.tile_size*46;
        
        gp.enemy[mapNum][3] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][3].worldx = gp.tile_size*5;
        gp.enemy[mapNum][3].worldy = gp.tile_size*44;
        
        gp.enemy[mapNum][4] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][4].worldx = gp.tile_size*10;
        gp.enemy[mapNum][4].worldy = gp.tile_size*39;
        
        gp.enemy[mapNum][5] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][5].worldx = gp.tile_size*40;
        gp.enemy[mapNum][5].worldy = gp.tile_size*25;
        
        gp.enemy[mapNum][6] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][6].worldx = gp.tile_size*5;
        gp.enemy[mapNum][6].worldy = gp.tile_size*27;
        
        gp.enemy[mapNum][7] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][7].worldx = gp.tile_size*8;
        gp.enemy[mapNum][7].worldy = gp.tile_size*19;
        
        gp.enemy[mapNum][8] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][8].worldx = gp.tile_size*4;
        gp.enemy[mapNum][8].worldy = gp.tile_size*7;
        
        gp.enemy[mapNum][9] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][9].worldx = gp.tile_size*26;
        gp.enemy[mapNum][9].worldy = gp.tile_size*10;
        
        gp.enemy[mapNum][10] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][10].worldx = gp.tile_size*34;
        gp.enemy[mapNum][10].worldy = gp.tile_size*11;
        
        gp.enemy[mapNum][11] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][11].worldx = gp.tile_size*47;
        gp.enemy[mapNum][11].worldy = gp.tile_size*19;
        
        gp.enemy[mapNum][12] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][12].worldx = gp.tile_size*46;
        gp.enemy[mapNum][12].worldy = gp.tile_size*10;
        
        gp.enemy[mapNum][13] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][13].worldx = gp.tile_size*37;
        gp.enemy[mapNum][13].worldy = gp.tile_size*3;
        
        gp.enemy[mapNum][14] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][14].worldx = gp.tile_size*29;
        gp.enemy[mapNum][14].worldy = gp.tile_size*5;
        
        gp.enemy[mapNum][15] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][15].worldx = gp.tile_size*4;
        gp.enemy[mapNum][15].worldy = gp.tile_size*2;
        
        gp.enemy[mapNum][16] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][16].worldx = gp.tile_size*3;
        gp.enemy[mapNum][16].worldy = gp.tile_size*22;
                
        gp.enemy[mapNum][16] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][16].worldx = gp.tile_size*3;
        gp.enemy[mapNum][16].worldy = gp.tile_size*21;
        
        gp.enemy[mapNum][17] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][17].worldx = gp.tile_size*4;
        gp.enemy[mapNum][17].worldy = gp.tile_size*33;
        
        gp.enemy[mapNum][18] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][18].worldx = gp.tile_size*3;
        gp.enemy[mapNum][18].worldy = gp.tile_size*38;
        
        gp.enemy[mapNum][19] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][19].worldx = gp.tile_size*37;
        gp.enemy[mapNum][19].worldy = gp.tile_size*34;
        
        mapNum = 1;//anything set under this will go on the sub map
        
        gp.enemy[mapNum][0] = new MOB_GreenSlime(gp);
        gp.enemy[mapNum][0].worldx = gp.tile_size*11;
        gp.enemy[mapNum][0].worldy = gp.tile_size*13;
        
        gp.enemy[mapNum][1] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][1].worldx = gp.tile_size*17;
        gp.enemy[mapNum][1].worldy = gp.tile_size*13;
        
        mapNum = 2;//anything set under this will go in the dungeon
        
        gp.enemy[mapNum][0] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][0].worldx = gp.tile_size*23;
        gp.enemy[mapNum][0].worldy = gp.tile_size*15;
        
        gp.enemy[mapNum][1] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][1].worldx = gp.tile_size*29;
        gp.enemy[mapNum][1].worldy = gp.tile_size*18;
        
        gp.enemy[mapNum][2] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][2].worldx = gp.tile_size*30;
        gp.enemy[mapNum][2].worldy = gp.tile_size*16;
        
        gp.enemy[mapNum][3] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][3].worldx = gp.tile_size*30;
        gp.enemy[mapNum][3].worldy = gp.tile_size*15;
        
        
        mapNum = 3;//anything set under this will go in the pit house
        gp.enemy[mapNum][0] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][0].worldx = gp.tile_size*23;
        gp.enemy[mapNum][0].worldy = gp.tile_size*18;
        
        gp.enemy[mapNum][1] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][1].worldx = gp.tile_size*31;
        gp.enemy[mapNum][1].worldy = gp.tile_size*17;
        
        gp.enemy[mapNum][2] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][2].worldx = gp.tile_size*21;
        gp.enemy[mapNum][2].worldy = gp.tile_size*19;
        
        
        mapNum = 4;//Laudromat
        gp.enemy[mapNum][0] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][0].worldx = gp.tile_size*29;
        gp.enemy[mapNum][0].worldy = gp.tile_size*12;
        
        gp.enemy[mapNum][1] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][1].worldx = gp.tile_size*25;
        gp.enemy[mapNum][1].worldy = gp.tile_size*8;
        
        gp.enemy[mapNum][2] = new MOB_RedSlime(gp);
        gp.enemy[mapNum][2].worldx = gp.tile_size*23;
        gp.enemy[mapNum][2].worldy = gp.tile_size*23;
        
        mapNum = 5;//Arcade gauntlet
        gp.enemy[mapNum][0] = new MOB_Pitcher(gp, "down");
        gp.enemy[mapNum][0].worldx = gp.tile_size*25;
        gp.enemy[mapNum][0].worldy = gp.tile_size*23;
        
        gp.enemy[mapNum][1] = new MOB_Pitcher(gp, "right");
        gp.enemy[mapNum][1].worldx = gp.tile_size*26;
        gp.enemy[mapNum][1].worldy = gp.tile_size*22;
        
        gp.enemy[mapNum][2] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][2].worldx = gp.tile_size*24;
        gp.enemy[mapNum][2].worldy = gp.tile_size*22;
        
        gp.enemy[mapNum][3] = new MOB_Pitcher(gp, "up");
        gp.enemy[mapNum][3].worldx = gp.tile_size*25;
        gp.enemy[mapNum][3].worldy = gp.tile_size*21;
        
        gp.enemy[mapNum][4] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][4].worldx = gp.tile_size*32;
        gp.enemy[mapNum][4].worldy = gp.tile_size*22;
        
        gp.enemy[mapNum][5] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][5].worldx = gp.tile_size*25;
        gp.enemy[mapNum][5].worldy = gp.tile_size*19;
        
        mapNum = 6;
        
        gp.enemy[mapNum][0] = new MOB_EvilCat(gp);
        gp.enemy[mapNum][0].worldx = gp.tile_size*25;
        gp.enemy[mapNum][0].worldy = gp.tile_size*25;
        
        gp.enemy[mapNum][1] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][1].worldx = gp.tile_size*27;
        gp.enemy[mapNum][1].worldy = gp.tile_size*25;
        
        gp.enemy[mapNum][2] = new MOB_Cyborg(gp);
        gp.enemy[mapNum][2].worldx = gp.tile_size*23;
        gp.enemy[mapNum][2].worldy = gp.tile_size*25;
        
        mapNum = 7;
        gp.enemy[mapNum][0] = new MOB_Pitcher(gp, "down");
        gp.enemy[mapNum][0].worldx = gp.tile_size*22;
        gp.enemy[mapNum][0].worldy = gp.tile_size*25;
        
        gp.enemy[mapNum][1] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][1].worldx = gp.tile_size*20;
        gp.enemy[mapNum][1].worldy = gp.tile_size*23;
        
        gp.enemy[mapNum][2] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][2].worldx = gp.tile_size*30;
        gp.enemy[mapNum][2].worldy = gp.tile_size*26;
        
        gp.enemy[mapNum][3] = new MOB_Pitcher(gp, "up");
        gp.enemy[mapNum][3].worldx = gp.tile_size*30;
        gp.enemy[mapNum][3].worldy = gp.tile_size*22;
        
        gp.enemy[mapNum][4] = new MOB_Pitcher(gp, "down");
        gp.enemy[mapNum][4].worldx = gp.tile_size*25;
        gp.enemy[mapNum][4].worldy = gp.tile_size*21;
        
        gp.enemy[mapNum][5] = new MOB_Pitcher(gp, "left");
        gp.enemy[mapNum][5].worldx = gp.tile_size*27;
        gp.enemy[mapNum][5].worldy = gp.tile_size*18;
        
        
        
        
        
        
    }
    
    //Takes current player position and spawns projecile on top of player
    public void set_proj(int x,int y){
        
        int i = 0;
        int mapNum = gp.currentMap;
        
        while(gp.pro[mapNum][i]!=null){
            i++;
        }
        
        if(gp.weaponSelect==gp.tShirtCannon){
            gp.pro[mapNum][i] = new PRO_Shirt(gp);
            gp.pro[mapNum][i].worldx = x;
            gp.pro[mapNum][i].worldy = y;
        }else if(gp.weaponSelect==gp.boxingGlove){
            gp.pro[mapNum][i] = new PRO_Punch(gp);
            gp.pro[mapNum][i].worldx = x;
            gp.pro[mapNum][i].worldy = y;
        }
        
    }
    
    public void setEnemyProj(int x, int y, String fireDirection){
        int i = 0;
        int mapNum = gp.currentMap;
        
        while(gp.mpro[mapNum][i]!=null){
            i++;
        }
        
        gp.mpro[mapNum][i] = new MPRO_Baseball(gp, fireDirection);
        gp.mpro[mapNum][i].worldx = x;
        gp.mpro[mapNum][i].worldy = y;
    }
}

