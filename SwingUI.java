
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


/**
 * Created by evdogg123 on 5/12/2018.
 */

public class SwingUI extends JFrame implements ActionListener {
    //Serves as the frame where the game window is held
    GameWorld gameWorld;
    Button startButton;
    HUD hud;

    SwingUI() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(1000, 1000);
        setupStart();
        hud = new HUD();
        add(hud);
    }

    void setupStart(){
        startButton = new Button("Start");
        startButton.addActionListener(this);
        add(startButton,BorderLayout.PAGE_END);
    }
    public void actionPerformed(ActionEvent event){
        gameWorld = new GameWorld();
        add(gameWorld);
        gameWorld.addKeyListener(gameWorld);
        gameWorld.setFocusable(true);
    }

    public void updateUI(LevelBuilder level){
        gameWorld.setGameObjects(level.objectArr);
        hud.setLevelStats(level);
        gameWorld.repaint();
        hud.repaint();
    }


}



