import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpriteAtlasLoader {
    private BufferedImage spriteSheet;

    public SpriteAtlasLoader(BufferedImage spriteSheet, String jsonFilePath) {
        this.spriteSheet = spriteSheet;
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            spriteAtlasData = mapper.readValue(new File(jsonFilePath), SpriteAtlasData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}