package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

import src.entity.Player;

public class Coin extends PickUp {
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
        super.onCollision();
    }

}
