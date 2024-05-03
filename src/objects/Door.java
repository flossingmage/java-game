package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends SuperObject {

    public Door() {
        this.name = "door";
        collisionOn = true;
        interactable = true;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/door.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interact() {
        collisionOn = false;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/door_Open.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
