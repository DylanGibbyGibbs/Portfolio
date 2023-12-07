/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Gibby
 */
public class Sound {
    
    //Variables that use Javax Sound
    Clip clip;
    URL soundURL[] = new URL[30];
    
    
    
    //This will hold all of the different sounds we will use. Currently we only have a placeholder that plays spoonman
    //Just like the tiles, we have it in an array.
    public Sound()
    {
        //THE MAPS HAVE ASSOCIATED MUSIC! IT CHANGES WHAT THE CURRENT BACKGROUND MUSIC IS WHEN MAP IS CHANGED. 
        soundURL[0] = getClass().getResource("/sound/Spoonman.wav"); //Overworld
        soundURL[1] = getClass().getResource("/sound/46and2.wav"); //Big Dawgs House
        soundURL[2] = getClass().getResource("/sound/Miami.wav"); //Dungeon
        soundURL[3] = getClass().getResource("/sound/Alive.wav"); //Brick House with Pit
        
        soundURL[4] = getClass().getResource("/sound/Allstar.wav"); //Laundromat
        soundURL[5] = getClass().getResource("/sound/Toxic.wav"); //Arcade
        
        soundURL[6] = getClass().getResource("/sound/Kickstart.wav");//Trash pit

        soundURL[7] = getClass().getResource("/sound/Jerry.wav");//screenhouse

        soundURL[7] = getClass().getResource("/sound/Jerry.wav");//Trash pit

        
        //Non-Maps
        soundURL[9] = getClass().getResource("/sound/Title.wav");
        soundURL[10] = getClass().getResource("/sound/Pause.wav");
        
        //Sound effects
        soundURL[11] = getClass().getResource("/sound/pickupkey.wav");
        soundURL[12] = getClass().getResource("/sound/opendoor.wav");
        soundURL[13] = getClass().getResource("/sound/rizz.wav");
        soundURL[14] = getClass().getResource("/sound/Cannon.wav");
        soundURL[15] = getClass().getResource("/sound/Punch.wav");
        
        
      
        
        
        
       
       
       
       
        
        
        
    }
    
    //Sets the desired soundfile based upon i.
    //It opens the coresponding sound via the URL
    public void setsoundfile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e)
        {
            System.out.println("error");
        }   
    }
    
    //Starts the loaded sound file
    public void play()
    {
     clip.start();
    }
    
    //loops the sound file that is playing
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    //Stops the sound file that is playing. 
    public void stopsound()
    {
       clip.stop();
    }
   
    
    
}
