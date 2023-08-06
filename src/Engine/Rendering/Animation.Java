package Engine.Rendering;
import java.util.List;

public class Animation{
    public String name;
    public List<Frame> frames;

    public Animation(String name, List<Frame> frames) {
        this.name = name;
        this.frames = frames;
    }
}