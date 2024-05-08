package src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.UI.inventory;

public class KeyHandler implements KeyListener {

    static public int right = 0, down = 0;

    public boolean upPressed, downPressed, leftPressed, rightPressed, interactPressed = false, inventoryPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (keyCode == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (keyCode == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (keyCode == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (keyCode == KeyEvent.VK_E) {
            interactPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (keyCode == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (keyCode == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (keyCode == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (keyCode == KeyEvent.VK_E) {
            interactPressed = false;
        }
        if (keyCode == KeyEvent.VK_I) {
            inventoryPressed = !inventoryPressed;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            if (4 > right && right < ((inventory.storgeSlots.size() - 1 - (down * 5))))
                right++;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            if (right > 0)
                right--;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            if ((inventory.storgeSlots.size() / 5) > down)
                down++;
        }
        if (keyCode == KeyEvent.VK_UP) {
            if (down > 0)
                down--;
        }
    }
}