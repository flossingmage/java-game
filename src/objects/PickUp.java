package src.objects;

import src.UI.inventory;

public class PickUp extends SuperObject{
    
    public PickUp(){
    }
    

    public void onCollision() {
        inventory.pickedUpItem(name,image);
        remove();
    }
    
}