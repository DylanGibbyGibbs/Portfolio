package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


//THIS IS THE MAIN. IT STARTS EVERYTHING
public class main_class {
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Big Dawg Adventures");
        ImageIcon img = new ImageIcon("/back1.png");
        window.setIconImage(img.getImage());
        
        game_panel game = new game_panel();
        window.add(game);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
         
        game.gameSetup();
        game.startGameThread();
}
}