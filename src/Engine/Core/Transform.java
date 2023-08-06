package Engine.Core;

public class Transform {

    //make it get and set
    public Vector2 position;
    public Vector2 rotation;
    public Vector2 scale;

    public Transform(){
        position = new Vector2(0,0);
        rotation = new Vector2(0,0);
        scale = new Vector2(1,1);
    }
    public Transform(Vector2 position, Vector2 rotation, Vector2 scale){
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }
    public void setRotation(Vector2 rotation){
        this.rotation = rotation;
    }
    public void setScale(Vector2 scale){
        this.scale = scale;
    }
    public Vector2 getPosition(){
        return position;
    }
    public Vector2 getRotation(){
        return rotation;
    }
    public Vector2 getScale(){
        return scale;
    }
}
