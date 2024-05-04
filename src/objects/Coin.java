package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

import src.entity.Player;
import src.main.UI.inventory;

public class Coin extends SuperObject {
    public Coin() {
        this.name = "coin";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/coin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCollision() {
        Player.NumOfCoins++;
        inventory.pickedUpItem(name, image);
        remove();
    }

}
