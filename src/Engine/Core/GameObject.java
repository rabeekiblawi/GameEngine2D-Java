package Engine.Core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;


public abstract class GameObject {

    private Transform transform;
    private Graphics2D g2d;
    private final List<Component> components;
    public String name;

    public GameObject(String name) {
        GameObectsPoolManager.addGameObject(this);
        this.transform = new Transform();
        this.components = new ArrayList<>();
        this.name = name;
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

    // This method adds a new component of the specified type
    public <T extends Component> T addComponent(Class<T> type) {
        try {
            T component = type.getDeclaredConstructor().newInstance();
            components.add(component);
            return component;
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Could not instantiate the component: " + type.getName());
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            System.err.println("No default constructor found for the component: " + type.getName());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("An error occurred while adding the component: " + type.getName());
            e.printStackTrace();
            return null;
        }
    }

    public abstract void init();

    public abstract void render();

    public abstract void update();
    
}
