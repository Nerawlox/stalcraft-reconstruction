/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.smart.moving.render.IModelPlayer;

public interface IRenderPlayer {
    public void superRenderRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9);

    public void superRenderRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4);

    public void superRenderRenderPlayerAt(AbstractClientPlayer var1, double var2, double var4, double var6);

    public void superRenderRenderName(EntityLivingBase var1, double var2, double var4, double var6);

    public gqqu getRenderManager();

    public IModelPlayer getPlayerModelBipedMain();

    public IModelPlayer getPlayerModelArmorChestplate();

    public IModelPlayer getPlayerModelArmor();

    public IModelPlayer[] getPlayerModels();
}

