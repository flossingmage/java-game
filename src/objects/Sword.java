package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Sword extends PickUp {
    public Sword() {
        this.name = "sword";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/sword.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCollision() {
        super.onCollision();
    }

}
