package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Pants extends PickUp {

    public Pants() {
        this.name = "pants";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/pants.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
