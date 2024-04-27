package src.tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager {

    GamePanel gamePanel;
    public Tile[][] tiles;
    public int mapTileNumber[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new Tile[10][10];
        mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("../../res/maps/map02.txt");
        for (int[] is : mapTileNumber) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void getTileImage() {
        try {
            tiles[0][0] = new Tile();
            tiles[0][0].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/Basic_Grass.jpg"));

            tiles[0][1] = new Tile();
            tiles[0][1].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/L_Grass.jpg"));

            tiles[0][2] = new Tile();
            tiles[0][2].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/R_Grass.jpg"));

            tiles[0][3] = new Tile();
            tiles[0][3].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/T_Grass.jpg"));

            tiles[0][4] = new Tile();
            tiles[0][4].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/B_Grass.jpg"));

            tiles[0][6] = new Tile();
            tiles[0][6].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/BL_Grass.jpg"));

            tiles[0][7] = new Tile();
            tiles[0][7].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/BR_Grass.jpg"));

            tiles[0][8] = new Tile();
            tiles[0][8].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/TL_Grass.jpg"));

            tiles[0][9] = new Tile();
            tiles[0][9].image = ImageIO.read(getClass().getResourceAsStream("../../tiles/TR_Grass.jpg"));

            // Basic_Grass.jpg
            tiles[1][0] = new Tile();
            tiles[1][0].image = ImageIO.read(getClass().getResourceAsStream("../../res/tiles/water.jpg"));
            // tiles[1][0].colliton = true;

            tiles[2][0] = new Tile();
            tiles[2][0].image = ImageIO.read(getClass().getResourceAsStream("../../res/tiles/brick.png"));
            tiles[2][0].colliton = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("3");
        }

    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
                String line = br.readLine();

                String[] tokens = line.split(" ");

                for (int x = 0; x < tokens.length; x++) {
                    mapTileNumber[row][col] = Integer.parseInt(tokens[x]);
                    col++;
                }
                col = 0;
                row++;
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("2");
        }
    }

    public void draw(Graphics2D g2d) {
        try {
            int worldCol = 0;
            int worldRow = 0;

            while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {

                int tileNum = mapTileNumber[worldCol][worldRow];

                int worldX = worldCol * gamePanel.tileSize;
                int worldY = worldRow * gamePanel.tileSize;

                int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
                int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

                if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                        worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                        worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                        worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                    if (tileNum == 0) {
                        if (worldCol == 0 || mapTileNumber[worldCol - 1][worldRow] != 0) {
                            if (worldRow == gamePanel.maxWorldRow -1 || mapTileNumber[worldCol][worldRow + 1] != 0) {
                                g2d.drawImage(tiles[tileNum][6].image, screenX, screenY, gamePanel.tileSize,
                                        gamePanel.tileSize, null);
                            } else if (worldRow == 0 || mapTileNumber[worldCol][worldRow - 1] != 0) {
                                g2d.drawImage(tiles[tileNum][8].image, screenX, screenY, gamePanel.tileSize,
                                        gamePanel.tileSize, null);
                            } else {
                                g2d.drawImage(tiles[tileNum][1].image, screenX, screenY, gamePanel.tileSize,
                                        gamePanel.tileSize, null);
                            }
                        } else if (worldCol == gamePanel.maxWorldCol -1 || mapTileNumber[worldCol + 1][worldRow] != 0) {
                            if (worldRow == gamePanel.maxWorldRow -1 || mapTileNumber[worldCol][worldRow + 1] != 0) {
                                g2d.drawImage(tiles[tileNum][7].image, screenX, screenY, gamePanel.tileSize,
                                        gamePanel.tileSize, null);
                            } else if (worldRow == 0 || mapTileNumber[worldCol][worldRow - 1] != 0) {
                                g2d.drawImage(tiles[tileNum][9].image, screenX, screenY, gamePanel.tileSize,
                                        gamePanel.tileSize, null);
                            } else {
                                g2d.drawImage(tiles[tileNum][2].image, screenX, screenY, gamePanel.tileSize,
                                        gamePanel.tileSize, null);
                            }
                        } else if (worldRow == gamePanel.maxWorldRow-1 || mapTileNumber[worldCol][worldRow + 1] != 0) {
                            g2d.drawImage(tiles[tileNum][4].image, screenX, screenY, gamePanel.tileSize,
                                    gamePanel.tileSize, null);
                        } else if (worldRow == 0 || mapTileNumber[worldCol][worldRow - 1] != 0) {
                            g2d.drawImage(tiles[tileNum][3].image, screenX, screenY, gamePanel.tileSize,
                                    gamePanel.tileSize, null);
                        } else {
                            g2d.drawImage(tiles[tileNum][0].image, screenX, screenY, gamePanel.tileSize,
                                    gamePanel.tileSize, null);
                        }

                    } else {
                        g2d.drawImage(tiles[tileNum][0].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize,
                                null);
                    }
                }
                worldCol++;
                if (worldCol == gamePanel.maxWorldCol) {
                    worldCol = 0;
                    worldRow++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1");
        }
    }

}