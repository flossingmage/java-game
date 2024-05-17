package src.UI;

import src.objects.PickUp;

public class StorgeSlot {
    public boolean empty = true;
    public PickUp item;
    public int quantity = 0;

    public StorgeSlot(PickUp item) {
        {
            this.empty = false;
            this.item = item;
            this.quantity = 1;

        }
    }

}
