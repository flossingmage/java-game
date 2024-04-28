package src.main;

import src.entity.Entity;

public class CollisionCheck {

    GamePanel gamePanel;

    public CollisionCheck(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
        // world position of the entity
        int entityLeftWorld = entity.worldX + entity.soidArea.x;
        int entityRightWorld = entity.worldX + entity.soidArea.x + entity.soidArea.width;
        int entityTopWorld = entity.worldY + entity.soidArea.y;
        int entityBottomWorld = entity.worldY + entity.soidArea.y + entity.soidArea.height;

        // tile position of the entity
        int entityLeftCol = entityLeftWorld / gamePanel.tileSize;
        int entityRightCol = entityRightWorld / gamePanel.tileSize;
        int entityTopRow = entityTopWorld / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorld / gamePanel.tileSize;

        boolean tile1 = false, tile2 = false;
        /** */
        try {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorld - entity.speed) / gamePanel.tileSize;
                    if (gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow] == 2)
                        tile1 = true;
                    if (gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow] == 2)
                        tile2 = true;
                    if (tile1 || tile2) {
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorld + entity.speed) / gamePanel.tileSize;
                    if (gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow] == 2)
                        tile1 = true;
                    if (gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow] == 2)
                        tile2 = true;
                    if (tile1 || tile2) {
                        entity.collisionOn = true;
                    }

                    break;

                case "left":
                    entityLeftCol = (entityLeftWorld - entity.speed) / gamePanel.tileSize;
                    if (gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow] == 2)
                        tile1 = true;
                    if (gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow] == 2)
                        tile2 = true;
                    if (tile1 || tile2) {
                        entity.collisionOn = true;
                    }
                    break;
                case "right":
                    entityRightCol = (entityRightWorld + entity.speed) / gamePanel.tileSize;
                    if (gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow] == 2)
                        tile1 = true;
                    if (gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow] == 2)
                        tile2 = true;
                    if (tile1 || tile2) {
                        entity.collisionOn = true;
                    }
                    break;
            }
        } catch (Exception e) {
            entity.collisionOn = true;
        }

    }
}
