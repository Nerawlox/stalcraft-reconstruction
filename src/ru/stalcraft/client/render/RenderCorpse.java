/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.loaders.StalkerModelManager;
import ru.stalcraft.client.models.ModelCorpse;
import ru.stalcraft.client.render.RenderBackpack;
import ru.stalcraft.client.render.RenderUtils;
import ru.stalcraft.client.render.RenderWeapon;
import ru.stalcraft.entity.EntityCorpse;
import ru.stalcraft.items.ItemArmorArtefakt;

public class RenderCorpse
extends bgu {
    ModelCorpse modelCorpse;
    ModelCorpse armor1;
    ModelCorpse armor2;

    public RenderCorpse() {
        super(new ModelCorpse(0.0f, 0.0f, 64, 32), 0.5f);
        this.modelCorpse = (ModelCorpse)this.a;
    }

    @Override
    protected void b() {
        this.armor1 = new ModelCorpse(1.0f, 0.0f, 64, 32);
        this.g = this.armor1;
        this.armor2 = new ModelCorpse(0.5f, 0.0f, 64, 32);
        this.h = this.armor2;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return ((EntityCorpse)par1Entity).getTexture();
    }

    public void renderCorpse(EntityCorpse corpse, double par2, double par4, double par6, float par8, float frame) {
        this.armor2.rotationFall = this.modelCorpse.rotationFall = RenderUtils.interpolateRotation(corpse.prevRotationFall, corpse.rotationFall, frame);
        this.armor1.rotationFall = this.modelCorpse.rotationFall;
        this.armor2.rotationRightHand = this.modelCorpse.rotationRightHand = RenderUtils.interpolateRotation(corpse.prevRightHandRotation, corpse.rightHandRotation, frame);
        this.armor1.rotationRightHand = this.modelCorpse.rotationRightHand;
        this.armor2.rotationLeftHand = this.modelCorpse.rotationLeftHand = RenderUtils.interpolateRotation(corpse.prevLeftHandRotation, corpse.leftHandRotation, frame);
        this.armor1.rotationLeftHand = this.modelCorpse.rotationLeftHand;
        super.a(corpse, par2, par4, par6, par8, frame);
    }

    @Override
    public void a(og par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderCorpse((EntityCorpse)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
    protected void a(og par1EntityLiving, float par2) {
    }

    @Override
    protected void c(of par1EntityLiving, float par2) {
        super.c(par1EntityLiving, par2);
        EntityCorpse corpse = (EntityCorpse)par1EntityLiving;
        StalkerModelManager m2 = ClientProxy.modelManager;
        GL11.glEnable((int)32826);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)1.35f, (float)0.0f);
        GL11.glRotatef((float)RenderUtils.interpolateRotation(corpse.prevRotationFall, corpse.rotationFall, par2), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)-1.35f, (float)0.0f);
        if (corpse.isFallingFinished) {
            GL11.glTranslatef((float)0.0f, (float)0.9f, (float)0.0f);
        }
        if (corpse.n(3) != null && corpse.n(3).b() instanceof ItemArmorArtefakt) {
            ItemArmorArtefakt backpack = (ItemArmorArtefakt)((Object)corpse.n(3).b());
            if (backpack.specialModelName != null) {
                m2.tryLoadTexture(backpack.specialModelTexture);
                m2.tryBindTexture(backpack.specialModelTexture);
                IModelCustom model = m2.getModel("armor", backpack.specialModelName + "_head." + backpack.extension);
                if (model != null) {
                    GL11.glPushMatrix();
                    this.a.c.c(0.0625f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_body." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.e.c(0.0625f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_rightarm." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.f.c(0.0625f);
                    GL11.glTranslatef((float)0.315f, (float)-0.13f, (float)0.0f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_leftarm." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.g.c(0.0625f);
                    GL11.glTranslatef((float)-0.315f, (float)-0.13f, (float)0.0f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_rightleg." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.h.c(0.0625f);
                    GL11.glTranslatef((float)0.13f, (float)-0.748f, (float)0.0f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_leftleg." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.i.c(0.0625f);
                    GL11.glTranslatef((float)-0.13f, (float)-0.748f, (float)0.0f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_rightboot." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.h.c(0.0625f);
                    GL11.glTranslatef((float)0.13f, (float)-0.748f, (float)0.0f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPopMatrix();
                }
                if ((model = m2.getModel("armor", backpack.specialModelName + "_leftboot." + backpack.extension)) != null) {
                    GL11.glPushMatrix();
                    this.a.i.c(0.0625f);
                    GL11.glTranslatef((float)-0.13f, (float)-0.748f, (float)0.0f);
                    GL11.glScalef((float)0.0626f, (float)0.0626f, (float)0.0626f);
                    model.renderAll();
                    GL11.glPushMatrix();
                }
            }
        }
        GL11.glPushMatrix();
        this.a.e.c(0.0625f);
        ye backpack1 = corpse.getBackpack();
        if (backpack1 != null) {
            RenderBackpack.renderBackpack(corpse, backpack1.d);
        }
        if (GuiSettingsStalker.renderEquippedWeapons) {
            this.renderEquippedWeapons(corpse, backpack1 != null);
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        GL11.glDisable((int)3042);
    }

    private void renderEquippedWeapons(EntityCorpse corpse, boolean backpack) {
        ye rifle = corpse.getRifle();
        ye pistol = corpse.getPistol();
        if (rifle != null && ClientProxy.weaponRenders.containsKey(rifle.d)) {
            ((RenderWeapon)ClientProxy.weaponRenders.get(rifle.d)).renderOnPlayer(corpse, backpack ? RenderWeapon.RenderType.BACKPACK_RIFLE : RenderWeapon.RenderType.RIFLE, rifle);
        }
        if (pistol != null && ClientProxy.weaponRenders.containsKey(pistol.d)) {
            ((RenderWeapon)ClientProxy.weaponRenders.get(pistol.d)).renderOnPlayer(corpse, RenderWeapon.RenderType.PISTOL, pistol);
        }
    }

    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderCorpse((EntityCorpse)par1Entity, par2, par4, par6, par8, par9);
    }
}

