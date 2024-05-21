package src.objects.equipment;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Chestplate extends Equipment {

    public Chestplate() {
        this.name = "chestplate";
        defence = 10;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../../res/objects/chestplate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean useItem() {
        return super.useItem(1);
    }

}
