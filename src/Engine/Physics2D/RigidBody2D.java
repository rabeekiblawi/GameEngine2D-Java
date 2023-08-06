package Engine.Physics2D;

import Engine.Core.Component;
import Engine.Core.Vector2;

public class RigidBody2D implements Component {
    private Vector2 velocity;
    private float mass;
    private float drag;
    private float angularDrag;
    private float rotation;
    private Vector2 centerOfMass;
    private boolean isKinematic;

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getDrag() {
        return drag;
    }

    public void setDrag(float drag) {
        this.drag = drag;
    }

    public float getAngularDrag() {
        return angularDrag;
    }

    public void setAngularDrag(float angularDrag) {
        this.angularDrag = angularDrag;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Vector2 getCenterOfMass() {
        return centerOfMass;
    }

    public void setCenterOfMass(Vector2 centerOfMass) {
        this.centerOfMass = centerOfMass;
    }

    public boolean isKinematic() {
        return isKinematic;
    }

    public void setKinematic(boolean isKinematic) {
        this.isKinematic = isKinematic;
    }

    public void applyForce(Vector2 force) {
        // implementation
    }

    public void applyForceAtPosition(Vector2 force, Vector2 position) {
        // implementation
    }
}
