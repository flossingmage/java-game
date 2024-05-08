package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Helmet extends PickUp {

    public Helmet() {
        this.name = "helmet";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/helmet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
