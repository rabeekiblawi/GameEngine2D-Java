package Engine.Core;

import java.util.List;

public   class GameObectsPoolManager {

    static public List<GameObject> GameObjectsPool;

    static public void addGameObject(GameObject gameObject){
        if(GameObjectsPool == null)
            GameObjectsPool = new java.util.ArrayList<>();
        GameObjectsPool.add(gameObject);
    }

    static public void removeGameObject(GameObject gameObject){
        GameObjectsPool.remove(gameObject);
    }



}
