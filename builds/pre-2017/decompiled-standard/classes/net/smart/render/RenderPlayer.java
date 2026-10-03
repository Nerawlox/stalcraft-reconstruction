/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.render.IModelPlayer;
import net.smart.render.IRenderPlayer;
import net.smart.render.ModelPlayer;
import net.smart.render.SmartRenderRender;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class RenderPlayer
extends xbdy
implements IRenderPlayer {
    private ModelBiped field_77108_b;
    private ModelBiped field_77111_i;
    private IModelPlayer[] allIModelPlayers;
    private final SmartRenderRender render = new SmartRenderRender(this);

    @Override
    public IModelPlayer createModel(ModelBiped modelBiped, float f) {
        return new ModelPlayer(f);
    }

    @Override
    public void initialize(ModelBiped modelBiped, ModelBiped modelBiped2, ModelBiped modelBiped3, float f) {
        this.field_77045_g = modelBiped;
        this.field_76989_e = f;
        Reflect.SetField(xbdy.class, this, Install.RenderPlayer_modelBipedMain, modelBiped);
        this.field_77108_b = modelBiped2;
        Reflect.SetField(xbdy.class, this, Install.RenderPlayer_modelArmorChestplate, this.field_77108_b);
        this.field_77111_i = modelBiped3;
        Reflect.SetField(xbdy.class, this, Install.RenderPlayer_modelArmor, this.field_77111_i);
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
    public void func_82441_a(EntityPlayer entityPlayer) {
        this.render.drawFirstPersonHand(entityPlayer);
    }

    @Override
    public void superDrawFirstPersonHand(EntityPlayer entityPlayer) {
        super.func_82441_a(entityPlayer);
    }

    @Override
    public void func_77102_a(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        this.render.rotatePlayer(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void superRotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        super.func_77102_a(abstractClientPlayer, f, f2, f3);
    }

    @Override
    public void func_77100_a(AbstractClientPlayer abstractClientPlayer, float f) {
        this.render.renderSpecials(abstractClientPlayer, f);
    }

    @Override
    public void superRenderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        super.func_77100_a(abstractClientPlayer, f);
    }

    @Override
    public float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        this.render.beforeHandleRotationFloat(entityLivingBase, f);
        float f2 = super.func_77044_a(entityLivingBase, f);
        this.render.afterHandleRotationFloat(entityLivingBase, f);
        return f2;
    }

    @Override
    public gqqu getRenderManager() {
        return this.field_76990_c;
    }

    @Override
    public ModelBiped getModelBipedMain() {
        return (ModelBiped)this.field_77045_g;
    }

    @Override
    public ModelBiped getModelArmorChestplate() {
        return this.field_77108_b;
    }

    @Override
    public ModelBiped getModelArmor() {
        return this.field_77111_i;
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

