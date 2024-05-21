package src.objects.equipment;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Sword extends Equipment {
    public Sword() {
        this.name = "sword";
        defence = 1;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../../res/objects/sword.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCollision() {
        super.onCollision();
    }

    @Override
    public boolean useItem() {
        return super.useItem(3);
    }

}
