/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.playerapi;

import api.player.model.ModelPlayer;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.IModelPlayer;
import net.smart.render.IRenderPlayer;
import net.smart.render.SmartRenderRender;
import net.smart.render.playerapi.SmartRender;

public class SmartRenderRenderPlayerBase
extends RenderPlayerBase
implements IRenderPlayer {
    private ModelPlayer[] allModelPlayers;
    private IModelPlayer[] allIModelPlayers;
    private SmartRenderRender render;

    public SmartRenderRenderPlayerBase(RenderPlayerAPI renderPlayerAPI) {
        super(renderPlayerAPI);
    }

    @Override
    public void afterLocalConstructing() {
        this.render = new SmartRenderRender(this);
    }

    @Override
    public IModelPlayer createModel(ModelBiped modelBiped, float f) {
        return SmartRender.getPlayerBase((ModelPlayer)modelBiped);
    }

    @Override
    public void initialize(ModelBiped modelBiped, ModelBiped modelBiped2, ModelBiped modelBiped3, float f) {
        this.renderPlayer.setMainModelField(modelBiped);
        this.renderPlayer.setShadowSizeField(0.5f);
        this.renderPlayer.setModelBipedMainField(modelBiped);
        this.renderPlayer.setModelArmorChestplateField(modelBiped2);
        this.renderPlayer.setModelArmorField(modelBiped3);
    }

    @Override
    public void renderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        this.render.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void superRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        super.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
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
    public void beforeHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        this.render.beforeHandleRotationFloat(entityLivingBase, f);
    }

    @Override
    public void afterHandleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        this.render.afterHandleRotationFloat(entityLivingBase, f);
    }

    @Override
    public gqqu getRenderManager() {
        return this.renderPlayer.getRenderManagerField();
    }

    @Override
    public ModelBiped getModelBipedMain() {
        return this.renderPlayer.getModelBipedMainField();
    }

    @Override
    public ModelBiped getModelArmorChestplate() {
        return this.renderPlayer.getModelArmorChestplateField();
    }

    @Override
    public ModelBiped getModelArmor() {
        return this.renderPlayer.getModelArmorField();
    }

    @Override
    public IModelPlayer[] getRenderModels() {
        ModelPlayer[] modelPlayerArray = ModelPlayer.getAllInstances();
        if (this.allModelPlayers != null && (this.allModelPlayers == modelPlayerArray || modelPlayerArray.length == 0 && this.allModelPlayers.length == 0)) {
            return this.allIModelPlayers;
        }
        this.allModelPlayers = modelPlayerArray;
        this.allIModelPlayers = new IModelPlayer[modelPlayerArray.length];
        for (int i = 0; i < this.allIModelPlayers.length; ++i) {
            this.allIModelPlayers[i] = SmartRender.getPlayerBase(this.allModelPlayers[i]);
        }
        return this.allIModelPlayers;
    }
}

