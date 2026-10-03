/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.NEIClientConfig;
import codechicken.nei.api.INEIModeHandler;
import codechicken.nei.config.OptionCycled;
import java.util.LinkedList;
import net.minecraft.world.World;

public class NEIInfo {
    public static final LinkedList<INEIModeHandler> modeHandlers = new LinkedList();

    public static void load(World world) {
        OptionCycled optionCycled = (OptionCycled)NEIClientConfig.getOptionList().getOption("inventory.cheatmode");
        optionCycled.parent.synthesizeEnvironment();
        if (!optionCycled.optionValid(optionCycled.value())) {
            optionCycled.copyGlobals();
            optionCycled.cycle();
        }
    }

    public static boolean isValidMode(int n) {
        for (INEIModeHandler iNEIModeHandler : modeHandlers) {
            if (iNEIModeHandler.isModeValid(n)) continue;
            return false;
        }
        return true;
    }
}

