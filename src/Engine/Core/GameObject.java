package Engine.Core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;


public abstract class GameObject {

    private Transform transform;
    private Graphics2D g2d;
    public final List<Component> components;

    public GameObject( ) {
        GameObectsPoolManager.addGameObject(this);
        this.transform = new Transform();
        this.components = new ArrayList<>();
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    // This method gets the component of the specified type if it exists
    public <T extends Component> T getComponent(Class<T> type) {
        return components.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findFirst()
                .orElse(null);
    }

    public <T extends Component> void addComponent(T component) {
        components.add(component);
    }



    public abstract void init();

    public abstract void render();

    public abstract void update();
    
}
