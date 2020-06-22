package org.peepeejr;

import com.dax.walker.DaxWalker;
import com.dax.walker.Server;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;
import org.rspeer.ui.Log;

@ScriptMeta(developer = "peepee jr", name = "Test", desc = "Test")
public class Main extends Script {

    @Override
    public void onStart() {
        Log.fine("This will be executed once on startup.");
        Constants.daxWalker = new DaxWalker(new Server("sub_DPjXXzL5DeSiPf", "PUBLIC-KEY"));
        super.onStart();
    }

    @Override
    public int loop() {
        while (Constants.player == null) {
            Constants.player = Players.getLocal();
        }
        Helper.mainLoop();
        return Random.nextInt(400, 600);
    }
}


























