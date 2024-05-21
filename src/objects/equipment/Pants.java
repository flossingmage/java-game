package src.objects.equipment;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Pants extends Equipment {

    public Pants() {
        this.name = "pants";
        defence = 7;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../../res/objects/pants.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean useItem() {
        return super.useItem(2);
    }

}
