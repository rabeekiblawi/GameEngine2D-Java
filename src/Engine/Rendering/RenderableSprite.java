package Engine.Rendering;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class RenderableSprite implements Cloneable{
    public String name;
    public List<BufferedImage> sprites;
    public RenderableSprite(){}

  @Override
public RenderableSprite clone() {
    try {
        RenderableSprite clone = (RenderableSprite) super.clone();
        clone.sprites = new ArrayList<>();
        clone.name = this.name;
        for (BufferedImage sprite : sprites) {
            clone.sprites.add(sprite);
        }
        return clone;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
}
}
