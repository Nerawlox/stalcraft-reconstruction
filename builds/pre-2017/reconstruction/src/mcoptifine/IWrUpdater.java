/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.List;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public interface IWrUpdater {
    public void initialize();

    public WorldRenderer makeWorldRenderer(World var1, List var2, int var3, int var4, int var5, int var6);

    public void preRender(cvgz var1, EntityLivingBase var2);

    public void postRender();

    public boolean updateRenderers(cvgz var1, EntityLivingBase var2, boolean var3);

    public void resumeBackgroundUpdates();

    public void pauseBackgroundUpdates();

    public void finishCurrentUpdate();

    public void terminate();
}

