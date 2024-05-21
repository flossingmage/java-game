package src.objects;

import src.UI.inventory;

public class PickUp extends SuperObject {
    public PickUp() {
    }

    public void onCollision() {
        inventory.pickedUpItem(this);
        remove();
    }

    public boolean useItem() {
        System.out.println("Used " + name);
        return true;
    }

}