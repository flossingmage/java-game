package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Mana_Potion extends PickUp {

    public Mana_Potion() {
        this.name = "mana_potion";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/mana_potion.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
