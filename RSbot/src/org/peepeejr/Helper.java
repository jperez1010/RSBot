package org.peepeejr;

import com.dax.walker.models.RSBank;
import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.ui.Log;

import java.util.function.Predicate;

public class Helper {

    private static void gaussianPause(int mu, int sigma) {
        Time.sleep((int) Math.abs((Random.nextGaussian() * sigma + mu)));
    }


    public static void mule() {
        //Go to grand Exchange
        //Open bank
        //Select "withdraw as a note"
        //Withdraw all potatoes
        //exchange grand exchange clerk
        //sell all potatoes
        //with all gold in inventory, move to the world that the mule is in
        //go to where the mule is in the wilderness
        //once your player has been killed:
        //  startup()
    }

    private static final int loopAmount = 100;
    private static final Predicate<Item> POTATO_PREDICATE = item -> item.getName().contains("Potato");

    public static void mainLoop() {
        Log.fine("Entering main loop");
        for (int i = 0; i < loopAmount; i++) {
            Log.fine("Loop " + i);
            while (!Inventory.isFull()){
                interact("Potato", "Pick Potato");
            }
            Constants.daxWalker.walkToBank(RSBank.DRAYNOR);
            depositInventory(POTATO_PREDICATE);
        }
        //mule();
    }

    private static void depositInventory(Predicate<Item> predicate) {
        if (Bank.isOpen()) {
            Bank.depositAll(predicate);
        }
    }

    private static void interact(String name, String action) {
        SceneObject sceneObject = SceneObjects.newQuery().names(name).results().nearest();
        gaussianPause(50, 10);
        sceneObject.interact(action);
        gaussianPause(600, 150);
    }
}
