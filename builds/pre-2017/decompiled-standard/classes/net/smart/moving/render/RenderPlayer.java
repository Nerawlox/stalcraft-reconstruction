/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.render.IModelPlayer;
import net.smart.moving.render.IRenderPlayer;
import net.smart.moving.render.ModelPlayer;
import net.smart.moving.render.SmartMovingRender;

public class RenderPlayer
extends net.smart.render.RenderPlayer
implements IRenderPlayer {
    private IModelPlayer[] allIModelPlayers;
    private final SmartMovingRender render = new SmartMovingRender(this);

    @Override
    public net.smart.render.IModelPlayer createModel(ModelBiped modelBiped, float f) {
        return new ModelPlayer(f);
    }

    @Override
    public void func_130009_a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        this.render.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void superRenderRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        super.func_130009_a(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void func_77102_a(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        this.render.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void superRenderRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        super.func_77102_a(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void func_77105_b(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        this.render.renderPlayerAt(abstractClientPlayer, d, d2, d3);
    }

    @Override
    public void superRenderRenderPlayerAt(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        super.func_77105_b(abstractClientPlayer, d, d2, d3);
    }

    @Override
    public void func_77033_b(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.render.renderName((EntityPlayer)entityLivingBase, d, d2, d3);
    }

    @Override
    public void superRenderRenderName(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.func_77033_b(entityLivingBase, d, d2, d3);
    }

    @Override
    public gqqu getRenderManager() {
        return this.field_76990_c;
    }

    @Override
    public IModelPlayer getPlayerModelBipedMain() {
        return (ModelPlayer)super.getModelBipedMain();
    }

    @Override
    public IModelPlayer getPlayerModelArmorChestplate() {
        return (ModelPlayer)super.getModelArmorChestplate();
    }

    @Override
    public IModelPlayer getPlayerModelArmor() {
        return (ModelPlayer)super.getModelArmor();
    }

    @Override
    public IModelPlayer[] getPlayerModels() {
        if (this.allIModelPlayers == null) {
            this.allIModelPlayers = new IModelPlayer[]{this.getPlayerModelBipedMain(), this.getPlayerModelArmorChestplate(), this.getPlayerModelArmor()};
        }
        return this.allIModelPlayers;
    }
}

