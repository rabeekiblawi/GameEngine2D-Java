package Engine.Rendering;

import java.awt.image.BufferedImage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
public class SpriteAtlasLoader {
    private BufferedImage spriteSheet;

    public SpriteAtlasLoader(BufferedImage spriteSheet, String jsonFilePath) {
        this.spriteSheet = spriteSheet;
        

    }
}