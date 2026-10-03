/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.IModelPlayer;

public interface IRenderPlayer {
    public IModelPlayer createModel(ModelBiped var1, float var2);

    public void initialize(ModelBiped var1, ModelBiped var2, ModelBiped var3, float var4);

    public void superRenderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9);

    public void superDrawFirstPersonHand(EntityPlayer var1);

    public void superRotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4);

    public void superRenderSpecials(AbstractClientPlayer var1, float var2);

    public gqqu getRenderManager();

    public ModelBiped getModelBipedMain();

    public ModelBiped getModelArmorChestplate();

    public ModelBiped getModelArmor();

    public IModelPlayer[] getRenderModels();
}

