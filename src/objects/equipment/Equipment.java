package src.objects.equipment;

import src.entity.Player;
import src.objects.PickUp;

public class Equipment extends PickUp {
    public int defence;

    public boolean useItem(int index) {
        if (Player.equipment[index] != this) {
            Player.equipment[index] = this;
            return true;
        }
        return false;
    }

}
