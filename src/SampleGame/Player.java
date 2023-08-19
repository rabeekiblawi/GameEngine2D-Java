package SampleGame;

import Engine.Core.GameObject;

public class Player extends GameObject {

    public Player( ) {
        super();
    }
    
    @Override
    public void init() {
        System.out.println("size "+components.size());
    }

    @Override
    public void render() {
    }

    @Override
    public void update() {
        System.out.println("size "+components.size());
    }

}