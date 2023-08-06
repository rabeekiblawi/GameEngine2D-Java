import Engine.Core.GameObectsPoolManager;
import Engine.Core.GameObject;

import javax.swing.*;
import java.awt.*;

public class GameLoop extends JFrame implements Runnable {

    private boolean running;
    public int x = 0;

    public GameLoop() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        running = false;
    }

    public void init() {

    }

    public void start() {
        running = true;
        new Thread(this).start();
        System.out.println(GameObectsPoolManager.GameObjectsPool.size() + "");
    }

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            processInput();
            updateGame();
            render();

            try {
                Thread.sleep(16); // Aim for about 60 frames per second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processInput() {
        // Handle input
    }

    private void updateGame() {
        // Update game state
    }

    private void render() {

    }
}
