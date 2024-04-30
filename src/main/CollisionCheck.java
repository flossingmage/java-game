package src.main;

import src.entity.Entity;
import src.objects.SuperObject;

public class CollisionCheck {

    GamePanel gamePanel;

    public CollisionCheck(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
        // world position
        int entityLeftWorld = entity.worldX + entity.soidArea.x;
        int entityRightWorld = entity.worldX + entity.soidArea.x + entity.soidArea.width;
        int entityTopWorld = entity.worldY + entity.soidArea.y;
        int entityBottomWorld = entity.worldY + entity.soidArea.y + entity.soidArea.height;

        // tile position
        int entityLeftCol = entityLeftWorld / gamePanel.tileSize;
        int entityRightCol = entityRightWorld / gamePanel.tileSize;
        int entityTopRow = entityTopWorld / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorld / gamePanel.tileSize;

        try {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorld - entity.speed) / gamePanel.tileSize;
                    for (SuperObject object : gamePanel.objects) {
                        if (object != null)
                            if ((object.WorldX == entityLeftCol || object.WorldX == entityRightCol)
                                    && object.WorldY == entityTopRow && object.collisionOn)
                                entity.collisionOn = true;
                    }
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]).colliton)
                        entity.collisionOn = true;
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]).colliton)
                        entity.collisionOn = true;
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorld + entity.speed) / gamePanel.tileSize;
                    for (SuperObject object : gamePanel.objects) {
                        if (object != null)
                            if ((object.WorldX == entityLeftCol || object.WorldX == entityRightCol)
                                    && object.WorldY == entityBottomRow
                                    && object.collisionOn)
                                entity.collisionOn = true;
                    }
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow]).colliton)
                        entity.collisionOn = true;
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow]).colliton)
                        entity.collisionOn = true;

                    break;

                case "left":
                    entityLeftCol = (entityLeftWorld - entity.speed) / gamePanel.tileSize;
                    for (SuperObject object : gamePanel.objects) {
                        if (object != null)
                            if (object.WorldX == entityLeftCol
                                    && (object.WorldY == entityBottomRow || object.WorldY == entityTopRow)
                                    && object.collisionOn)
                                entity.collisionOn = true;
                    }
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow]).colliton)
                        entity.collisionOn = true;
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow]).colliton)
                        entity.collisionOn = true;
                    break;
                case "right":
                    entityRightCol = (entityRightWorld + entity.speed) / gamePanel.tileSize;
                    for (SuperObject object : gamePanel.objects) {
                        if (object != null)
                            if (object.WorldX == entityRightCol
                                    && (object.WorldY == entityBottomRow || object.WorldY == entityTopRow)
                                    && object.collisionOn)
                                entity.collisionOn = true;
                    }
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow]).colliton)
                        entity.collisionOn = true;
                    if (gamePanel.tileManager.tiles
                            .get(gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow]).colliton)
                        entity.collisionOn = true;

                    break;
            }
        } catch (Exception e) {
            entity.collisionOn = true;
        }

    }
}
