package src.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager {

    GamePanel gamePanel;
    public HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();
    public int mapTileNumber[][];
    public Tile grass, water, brick, L_Grass, R_Grass, T_Grass, D_Grass, LT_Grass, RT_Grass, LD_Grass, RD_Grass;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
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
            grass = new Tile();
            grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/Basic_Grass.jpg"));
            tiles.put(0, grass);

            water = new Tile();
            water.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/water.jpg"));
            tiles.put(1, water);

            brick = new Tile();
            brick.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/brick.png"));
            brick.colliton = true;
            tiles.put(2, brick);

            L_Grass = new Tile();
            L_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/L_Grass.jpg"));

            R_Grass = new Tile();
            R_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/R_Grass.jpg"));

            T_Grass = new Tile();
            T_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/T_Grass.jpg"));

            D_Grass = new Tile();
            D_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/B_Grass.jpg"));

            LT_Grass = new Tile();
            LT_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/TL_Grass.jpg"));

            RT_Grass = new Tile();
            RT_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/TR_Grass.jpg"));

            LD_Grass = new Tile();
            LD_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/BL_Grass.jpg"));

            RD_Grass = new Tile();
            RD_Grass.image = ImageIO.read(getClass().getResourceAsStream("../../tiles/BR_Grass.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
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
                        g2d.drawImage(getGrassImage(worldCol, worldRow), screenX, screenY, gamePanel.tileSize,
                                gamePanel.tileSize,
                                null);
                    } else {
                        g2d.drawImage(tiles.get(tileNum).image, screenX, screenY, gamePanel.tileSize,
                                gamePanel.tileSize,
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

    public BufferedImage getGrassImage(int worldCol, int worldRow) {
        try {
            boolean left = false, right = false, top = false, down = false;
            if (worldCol == 0 || mapTileNumber[worldCol - 1][worldRow] != 0)
                left = true;
            if (worldCol == gamePanel.maxWorldCol - 1 || mapTileNumber[worldCol + 1][worldRow] != 0)
                right = true;
            if (worldRow == 0 || mapTileNumber[worldCol][worldRow - 1] != 0)
                top = true;
            if (worldRow == gamePanel.maxWorldRow - 1 || mapTileNumber[worldCol][worldRow + 1] != 0)
                down = true;
            if (left && top)
                return LT_Grass.image;
            if (right && top)
                return RT_Grass.image;
            if (left && down)
                return LD_Grass.image;
            if (right && down)
                return RD_Grass.image;
            if (left)
                return L_Grass.image;
            if (right)
                return R_Grass.image;
            if (top)
                return T_Grass.image;
            if (down)
                return D_Grass.image;
            return grass.image;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(L_Grass);
            System.out.println(grass);
        }
        return null;
    }
}

/**
 * boolean left, right, up, down = false;
 * if (worldCol == 0 || mapTileNumber[worldCol - 1][worldRow] != 0)
 * 
 * 
 */