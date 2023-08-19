import Engine.Rendering.SpriteAtlasLoader;

public class Main {
    public static void main(String[] args) {

        SpriteAtlasLoader spriteAtlasLoader = new SpriteAtlasLoader("src\\SampleGame\\Assets\\mario-like.png",
                "src\\SampleGame\\Assets\\mario-like.json");

        GameLoop game = new GameLoop(spriteAtlasLoader.getGameEntities());
        game.init();
        game.start();
    }
}