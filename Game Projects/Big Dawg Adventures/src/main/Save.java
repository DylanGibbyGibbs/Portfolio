/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ltmer
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Save {
    File save;
    game_panel gp;
    
    public Save(game_panel gp){
        this.gp = gp;
    }
    
    public void SaveGame(){
        try{
            FileWriter writer = new FileWriter("BDA_SAVE.txt");
            writer.write(gp.hasCannon + " ");
            writer.write(gp.hasBoxing + " ");
            writer.write(gp.currentMap + " ");
            writer.write(gp.myplayer.worldx + " ");
            writer.write(gp.myplayer.worldy + " ");
            writer.write(gp.weaponSelect + " ");
            writer.write(gp.myplayer.life + " ");
            writer.write(gp.hasBoots + " ");
            writer.write(gp.hasHelmet + " ");
            writer.write(gp.armorSelect + " ");
            writer.write(gp.hasKey1 + " ");
            writer.write(gp.hasKey2 + " ");
            writer.write(gp.hasKey3 + " ");
            writer.write(gp.myplayer.hasKey + " ");
            writer.write(gp.doorsOpen + " ");
            writer.close();
            System.out.println("Game Saved");
            
        }catch (IOException e){
            System.out.println("Error Saving");
        }
    }
   
    public void CreateSave(){
        try{
            save = new File("BDA_SAVE.txt");
            if(save.createNewFile()){
                System.out.println("Save Created");
            }else{
                System.out.println("there's already a save");
            }
        }catch(IOException e){
            System.out.println("Error Creating Save");
        }
        
    }
    
    public boolean LoadSave(){
        
        try {
            Scanner load = new Scanner(new File("BDA_SAVE.txt"));
            String read;
            while(load.hasNextLine()){
                read = load.nextLine();
                
                String[] line = read.split(" ");
                gp.hasCannon = Boolean.parseBoolean(line[0]);
                gp.hasBoxing = Boolean.parseBoolean(line[1]);
                gp.currentMap = Integer.parseInt(line[2]);
                gp.currentbgm = Integer.parseInt(line[2]);
                gp.myplayer.worldx = Integer.parseInt(line[3]);
                gp.myplayer.worldy = Integer.parseInt(line[4]);
                gp.weaponSelect = Integer.parseInt(line[5]);
                gp.myplayer.life = Integer.parseInt(line[6]);
                gp.hasBoots = Boolean.parseBoolean(line[7]);
                gp.hasHelmet = Boolean.parseBoolean(line[8]);
                gp.armorSelect = Integer.parseInt(line[9]);
                gp.hasKey1 = Boolean.parseBoolean(line[10]);
                gp.hasKey2 = Boolean.parseBoolean(line[11]);
                gp.hasKey3 = Boolean.parseBoolean(line[12]);
                gp.myplayer.hasKey = Integer.parseInt(line[13]);
                gp.doorsOpen = Integer.parseInt(line[14]);
                return true;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No Save Data");
        }
        return false;
        
    }
    
    public void LoadNewGame(){
        try {
            Scanner load = new Scanner(new File("NewGame.txt"));
            String read;
            while(load.hasNextLine()){
                read = load.nextLine();
                
                String[] line = read.split(" ");
                gp.hasCannon = Boolean.parseBoolean(line[0]);
                gp.hasBoxing = Boolean.parseBoolean(line[1]);
                gp.currentMap = Integer.parseInt(line[2]);
                gp.currentbgm = Integer.parseInt(line[2]);
                gp.myplayer.worldx = Integer.parseInt(line[3]);
                gp.myplayer.worldy = Integer.parseInt(line[4]);
                gp.weaponSelect = Integer.parseInt(line[5]);
                gp.myplayer.life = Integer.parseInt(line[6]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No Save Data");
        }
    }
}
