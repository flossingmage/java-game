package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

import src.entity.Player;

public class Coin extends SuperObject{
    public Coin(){
        this.name = "coin";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/coin.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interact() {
        Player.NumOfCoins++;
    }
    
}
