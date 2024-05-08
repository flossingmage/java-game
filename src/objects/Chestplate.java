package src.objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Chestplate extends PickUp{
        
            public Chestplate() {
                this.name = "chestplate";
                try {
                    this.image = ImageIO.read(getClass().getResourceAsStream("../../res/objects/chestplate.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    
}
