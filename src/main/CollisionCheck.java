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

        int tile1, tile2;
        try {
            switch (entity.direction) {
                case "up":
                    entityTopRow = (entityTopWorld - entity.speed) / gamePanel.tileSize;
                    tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                    tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                    if (gamePanel.tileManager.tiles[tile1][0].colliton || gamePanel.tileManager.tiles[tile2][0].colliton) {
                        entity.collisionOn = true;
                    }
                    break;
                case "down":
                    entityBottomRow = (entityBottomWorld + entity.speed) / gamePanel.tileSize;
                    tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                    tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                    if (gamePanel.tileManager.tiles[tile1][0].colliton || gamePanel.tileManager.tiles[tile2][0].colliton) {
                        entity.collisionOn = true;
                    }

                    break;

                case "left":
                    entityLeftCol = (entityLeftWorld - entity.speed) / gamePanel.tileSize;
                    tile1 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                    tile2 = gamePanel.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                    if (gamePanel.tileManager.tiles[tile1][0].colliton || gamePanel.tileManager.tiles[tile2][0].colliton) {
                        entity.collisionOn = true;
                    }

                    break;
                case "right":
                    entityRightCol = (entityRightWorld + entity.speed) / gamePanel.tileSize;
                    tile1 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                    tile2 = gamePanel.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                    if (gamePanel.tileManager.tiles[tile1][0].colliton || gamePanel.tileManager.tiles[tile2][0].colliton) {
                        entity.collisionOn = true;
                    }
                    break;
            }
        } catch (Exception e) {
            entity.collisionOn = true;
        }

    }
}
