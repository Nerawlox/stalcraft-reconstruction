/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.ModLogger;
import carpentersblocks.util.handler.FeatureHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

public class PlantHandler {
    private static Method canThisPlantGrowOnThisBlockID;

    public static boolean init() {
        try {
            canThisPlantGrowOnThisBlockID = ReflectionHelper.findMethod(aorr.class, null, new String[]{"canThisPlantGrowOnThisBlockID"}, Integer.TYPE);
            ModLogger.log(Level.INFO, "Plant support integration successful.");
            return true;
        }
        catch (Exception exception) {
            ModLogger.log(Level.WARNING, "Plant support integration failed.");
            return false;
        }
    }

    public static boolean canThisPlantGrowOnThisBlockID(int n) {
        boolean bl = false;
        try {
            boolean bl2;
            bl = bl2 = ((Boolean)canThisPlantGrowOnThisBlockID.invoke(null, n)).booleanValue();
        }
        catch (InvocationTargetException invocationTargetException) {
            ModLogger.log(Level.WARNING, "Extended plant compatibility failed, disabling plant support integration.");
            FeatureHandler.enablePlantSupport = false;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return bl;
    }
}

