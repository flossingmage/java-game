package src.objects.equipment;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Helmet extends Equipment {

    public Helmet() {
        this.name = "helmet";
        defence = 5;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../../res/objects/helmet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean useItem() {
        return super.useItem(0);
    }

}
