package Engine.Core;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2 DistanceTo(Vector2 other){
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 Add(Vector2 other){
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 Sub(Vector2 other){
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 Scale(float factor){
        return new Vector2(this.x * factor, this.y * factor);
    }

    public Vector2 Scale(float x, float y){
        return new Vector2(this.x * x, this.y * y);
    }

    public Vector2 Normalize(){
        float magnitude = (float)Math.sqrt(this.x * this.x + this.y * this.y);
        return new Vector2(this.x / magnitude, this.y / magnitude);
    }

    public float Magnitude(){
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public float Dot(Vector2 other){
        return this.x * other.x + this.y * other.y;
    }

    public float Cross(Vector2 other){
        return this.x * other.y - this.y * other.x;
    }

    public float Angle(Vector2 other){
        return (float)Math.atan2(this.Cross(other), this.Dot(other));
    }

    public Vector2 Rotate(float angle){
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);
        return new Vector2(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }

    public Vector2 Lookat(Vector2 other){
        return other.Sub(this).Normalize();
    }
}
