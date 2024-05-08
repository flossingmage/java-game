package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Health_Potion extends PickUp{

    public Health_Potion() {
        this.name = "health_potion";
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/health_potion.png"));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    
}
