package Engine.Rendering;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SpriteAtlasLoader {
    private BufferedImage spriteSheet;
    private List<RenderableSprite> gameEntities;

    public List<RenderableSprite> getGameEntities() {
        return gameEntities;
    }

    public SpriteAtlasLoader(String spriteSheetPath, String jsonPath) {
        try {
            this.spriteSheet = ImageIO.read(new File(spriteSheetPath));
            System.out.println(this.spriteSheet.getWidth() + " " + this.spriteSheet.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gameEntities = loadSpritesFromJson(jsonPath);
    }

    private List<RenderableSprite> loadSpritesFromJson(String jsonPath) {
        List<RenderableSprite> gameEntities = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonPath)));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonGameEntities = jsonObject.getJSONArray("gameEntities");

            for (int i = 0; i < jsonGameEntities.length(); i++) {
                JSONObject jsonGameEntity = jsonGameEntities.getJSONObject(i);
                String name = jsonGameEntity.getString("name");
                JSONArray entitySprites = jsonGameEntity.getJSONArray("sprites");

                List<BufferedImage> sprites = new ArrayList<>();
                for (int j = 0; j < entitySprites.length(); j++) {
                    JSONObject sprite = entitySprites.getJSONObject(j);
                    int x_start = sprite.getInt("x_start");
                    int y_start = sprite.getInt("y_start");
                    int x_end = sprite.getInt("x_end");
                    int y_end = sprite.getInt("y_end");
                    int width = x_end - x_start;
                    int height = y_end - y_start;

                    BufferedImage bufferedImage = spriteSheet.getSubimage(x_start, y_start, width, height);
                    sprites.add(bufferedImage);
                }

                RenderableSprite renderableSprite = new RenderableSprite();
                renderableSprite.name = name;
                renderableSprite.sprites = sprites;
                gameEntities.add(renderableSprite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameEntities;
    }
}
