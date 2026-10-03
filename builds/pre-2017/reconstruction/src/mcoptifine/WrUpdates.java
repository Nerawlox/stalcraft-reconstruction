/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.List;
import mcoptifine.IWrUpdater;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class WrUpdates {
    private static IWrUpdater wrUpdater = null;

    public static void setWrUpdater(IWrUpdater iWrUpdater) {
        if (wrUpdater != null) {
            wrUpdater.terminate();
        }
        if ((wrUpdater = iWrUpdater) != null) {
            try {
                wrUpdater.initialize();
            }
            catch (Exception exception) {
                wrUpdater = null;
                exception.printStackTrace();
            }
        }
    }

    public static boolean hasWrUpdater() {
        return wrUpdater != null;
    }

    public static IWrUpdater getWrUpdater() {
        return wrUpdater;
    }

    public static WorldRenderer makeWorldRenderer(World world, List list2, int n, int n2, int n3, int n4) {
        return wrUpdater == null ? new WorldRenderer(world, list2, n, n2, n3, n4) : wrUpdater.makeWorldRenderer(world, list2, n, n2, n3, n4);
    }

    public static boolean updateRenderers(cvgz cvgz2, EntityLivingBase entityLivingBase, boolean bl) {
        try {
            return wrUpdater.updateRenderers(cvgz2, entityLivingBase, bl);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            WrUpdates.setWrUpdater(null);
            return false;
        }
    }

    public static void resumeBackgroundUpdates() {
        if (wrUpdater != null) {
            wrUpdater.resumeBackgroundUpdates();
        }
    }

    public static void pauseBackgroundUpdates() {
        if (wrUpdater != null) {
            wrUpdater.pauseBackgroundUpdates();
        }
    }

    public static void finishCurrentUpdate() {
        if (wrUpdater != null) {
            wrUpdater.finishCurrentUpdate();
        }
    }

    public static void preRender(cvgz cvgz2, EntityLivingBase entityLivingBase) {
        if (wrUpdater != null) {
            wrUpdater.preRender(cvgz2, entityLivingBase);
        }
    }

    public static void postRender() {
        if (wrUpdater != null) {
            wrUpdater.postRender();
        }
    }
}

