/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.render.playerapi;

import api.player.model.ModelPlayer;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.render.IModelPlayer;
import net.smart.moving.render.IRenderPlayer;
import net.smart.moving.render.SmartMovingRender;
import net.smart.moving.render.playerapi.SmartMoving;

public class SmartMovingRenderPlayerBase
extends RenderPlayerBase
implements IRenderPlayer {
    private ModelPlayer[] allModelPlayers;
    private IModelPlayer[] allIModelPlayers;
    private SmartMovingRender render;

    public SmartMovingRenderPlayerBase(RenderPlayerAPI renderPlayerAPI) {
        super(renderPlayerAPI);
    }

    @Override
    public void afterLocalConstructing() {
        this.render = new SmartMovingRender(this);
    }

    @Override
    public void renderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        this.render.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
    }

    @Override
    public void superRenderRenderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        super.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
    }

    public void superDrawFirstPersonHand(EntityPlayer entityPlayer) {
        super.renderFirstPersonArm(entityPlayer);
    }

    @Override
    public void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        this.render.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void superRenderRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        super.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void renderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        this.render.renderPlayerAt(abstractClientPlayer, d, d2, d3);
    }

    @Override
    public void superRenderRenderPlayerAt(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        super.renderPlayerSleep(abstractClientPlayer, d, d2, d3);
    }

    @Override
    public void passSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.render.renderName((EntityPlayer)entityLivingBase, d, d2, d3);
    }

    @Override
    public void superRenderRenderName(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        super.passSpecialRender(entityLivingBase, d, d2, d3);
    }

    public void superRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        super.renderSpecials(abstractClientPlayer, f);
    }

    @Override
    public RenderManager getRenderManager() {
        return this.renderPlayer.getRenderManagerField();
    }

    public boolean isRenderedWithBodyTopAlwaysInAccelerateDirection() {
        return this.render.modelBipedMain.isFlying || this.render.modelBipedMain.isSwim || this.render.modelBipedMain.isDive || this.render.modelBipedMain.isHeadJump;
    }

    @Override
    public IModelPlayer getPlayerModelArmor() {
        return SmartMoving.getPlayerBase((ModelPlayer)this.renderPlayer.getModelArmorField());
    }

    @Override
    public IModelPlayer getPlayerModelArmorChestplate() {
        return SmartMoving.getPlayerBase((ModelPlayer)this.renderPlayer.getModelArmorChestplateField());
    }

    @Override
    public IModelPlayer getPlayerModelBipedMain() {
        return SmartMoving.getPlayerBase((ModelPlayer)this.renderPlayer.getModelBipedMainField());
    }

    @Override
    public IModelPlayer[] getPlayerModels() {
        ModelPlayer[] modelPlayerArray = ModelPlayer.getAllInstances();
        if (this.allModelPlayers != null && (this.allModelPlayers == modelPlayerArray || modelPlayerArray.length == 0 && this.allModelPlayers.length == 0)) {
            return this.allIModelPlayers;
        }
        this.allModelPlayers = modelPlayerArray;
        this.allIModelPlayers = new IModelPlayer[modelPlayerArray.length];
        for (int i = 0; i < this.allIModelPlayers.length; ++i) {
            this.allIModelPlayers[i] = SmartMoving.getPlayerBase(this.allModelPlayers[i]);
        }
        return this.allIModelPlayers;
    }
}

