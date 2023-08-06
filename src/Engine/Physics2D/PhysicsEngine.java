package Engine.Physics2D;

import Engine.Core.GameObectsPoolManager;

import java.util.ArrayList;

public class PhysicsEngine {

    ArrayList<RigidBody2D> getRigidbodiers(){
        
        var rigidBodies2D = new java.util.ArrayList<RigidBody2D>();
        GameObectsPoolManager.GameObjectsPool.forEach(gameObject -> {
            if(gameObject.getComponent(RigidBody2D.class) != null)
                rigidBodies2D.add(gameObject.getComponent(RigidBody2D.class));
        });
        return  rigidBodies2D;
    }
    public static void fixedupdate(float deltaTime) {

    }
}
