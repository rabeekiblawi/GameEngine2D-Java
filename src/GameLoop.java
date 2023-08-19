import Engine.Core.GameObectsPoolManager;
import Engine.Core.GameObject;
import Engine.Rendering.RenderableSprite;
import SampleGame.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameLoop extends JFrame implements Runnable {

    private boolean running;
    public int x = 0;
    public Player Player = new Player();

    public GameLoop(List<RenderableSprite> sprites) {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        running = false;
    }

    public void init() {
        GameObectsPoolManager.init();
        SampleGame.Player player = new SampleGame.Player();
    }

    public void start() {
         GameObectsPoolManager.GameObjectsPool.forEach(gameObject -> {
            gameObject.init();
        });
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
        GameObectsPoolManager.GameObjectsPool.forEach(GameObject::update);
    }

    private void render() {
        GameObectsPoolManager.GameObjectsPool.forEach(GameObject::render);
    }
}
