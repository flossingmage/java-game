package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends SuperObject {

    public Door() {
        this.name = "door";
        collisionOn = true;
        interactable = true;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/doorFull.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interact() {
        collisionOn = false;
        System.out.println("interacted with door");
        try {
            if (!collisionOn) {
                this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/doorFullOpen.png"));
            } else {
                this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/doorFull.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
