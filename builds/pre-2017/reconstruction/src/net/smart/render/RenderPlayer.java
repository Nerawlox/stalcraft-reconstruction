/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.IModelPlayer;
import net.smart.render.IRenderPlayer;
import net.smart.render.ModelPlayer;
import net.smart.render.SmartRenderRender;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class RenderPlayer
extends net.minecraft.client.renderer.entity.RenderPlayer
implements IRenderPlayer {
    private ModelBiped modelArmorChestplate;
    private ModelBiped modelArmor;
    private IModelPlayer[] allIModelPlayers;
    private final SmartRenderRender render = new SmartRenderRender(this);

    @Override
    public IModelPlayer createModel(ModelBiped modelBiped, float f) {
        return new ModelPlayer(f);
    }

    @Override
    public void initialize(ModelBiped modelBiped, ModelBiped modelBiped2, ModelBiped modelBiped3, float f) {
        this.mainModel = modelBiped;
        this.shadowSize = f;
        Reflect.SetField(net.minecraft.client.renderer.entity.RenderPlayer.class, this, Install.RenderPlayer_modelBipedMain, modelBiped);
        this.modelArmorChestplate = modelBiped2;
        Reflect.SetField(net.minecraft.client.renderer.entity.RenderPlayer.class, this, Install.RenderPlayer_modelArmorChestplate, this.modelArmorChestplate);
        this.modelArmor = modelBiped3;
        Reflect.SetField(net.minecraft.client.renderer.entity.RenderPlayer.class, this, Install.RenderPlayer_modelArmor, this.modelArmor);
    }

    @Override
    public void func_130009_a(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        this.render.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void superRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        super.func_130009_a(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void renderFirstPersonArm(EntityPlayer entityPlayer) {
        this.render.drawFirstPersonHand(entityPlayer);
    }

    @Override
    public void superDrawFirstPersonHand(EntityPlayer entityPlayer) {
        super.renderFirstPersonArm(entityPlayer);
    }

    @Override
    public void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        this.render.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void superRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        super.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void renderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        this.render.renderSpecials(abstractClientPlayer, f);
    }

    @Override
    public void superRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        super.renderSpecials(abstractClientPlayer, f);
    }

    @Override
    public float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        this.render.beforeHandleRotationFloat(entityLivingBase, f);
        float f2 = super.handleRotationFloat(entityLivingBase, f);
        this.render.afterHandleRotationFloat(entityLivingBase, f);
        return f2;
    }

    @Override
    public RenderManager getRenderManager() {
        return this.renderManager;
    }

    @Override
    public ModelBiped getModelBipedMain() {
        return (ModelBiped)this.mainModel;
    }

    @Override
    public ModelBiped getModelArmorChestplate() {
        return this.modelArmorChestplate;
    }

    @Override
    public ModelBiped getModelArmor() {
        return this.modelArmor;
    }

    public IModelPlayer getRenderModelBipedMain() {
        return (ModelPlayer)this.getModelBipedMain();
    }

    public IModelPlayer getRenderModelArmorChestplate() {
        return (ModelPlayer)this.getModelArmorChestplate();
    }

    public IModelPlayer getRenderModelArmor() {
        return (ModelPlayer)this.getModelArmor();
    }

    @Override
    public IModelPlayer[] getRenderModels() {
        if (this.allIModelPlayers == null) {
            this.allIModelPlayers = new IModelPlayer[]{this.getRenderModelBipedMain(), this.getRenderModelArmorChestplate(), this.getRenderModelArmor()};
        }
        return this.allIModelPlayers;
    }
}

