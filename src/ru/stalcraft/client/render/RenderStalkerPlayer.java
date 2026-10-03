/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bbo
 *  bcp
 *  beu
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.loaders.StalkerModelManager;
import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.client.render.RenderBackpack;
import ru.stalcraft.client.render.RenderHandcuffs;
import ru.stalcraft.client.render.RenderWeapon;
import ru.stalcraft.items.ItemArmorArtefakt;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class RenderStalkerPlayer
extends bhj {
    private bbj modelBiped;
    private IModelCustom model;
    public static float scale;
    public static float translateX;
    public static float translateY;
    public static float translateZ;

    public RenderStalkerPlayer() {
        this.modelBiped = (bbj)this.i;
    }

    @Override
    protected bjo a(nn par1Entity) {
        return super.a(par1Entity);
    }

    @Deprecated
    private void printModel(bbo model) {
        Iterator it2 = model.r.iterator();
        bcu mr = null;
        bcp cube = null;
        String str = null;
        while (it2.hasNext()) {
            mr = (bcu)it2.next();
            cube = (bcp)mr.l.get(0);
            str = "boxName=" + mr.n + ", offsetX=" + mr.o + ", offsetY=" + mr.p + ", offsetZ=" + mr.q + ", raX=" + mr.f + ", raY=" + mr.g + ", raZ=" + mr.h + ", rpX=" + mr.c + ", rpY=" + mr.d + ", rpZ=" + mr.e + ", th=" + mr.b + ", tw=" + mr.a + ", hidden=" + mr.k + ", mirror=" + mr.i + ", showModel=" + mr.j + ", cubesCount=" + mr.l.size();
            str = str + ", sth=" + cube.g + ", x1=" + cube.a + ", x2=" + cube.d + ", y1=" + cube.b + ", y2=" + cube.e + ", z1=" + cube.c + ", z2=" + cube.f;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void renderStalkerArmor(uf player, float par2) {
        StalkerModelManager m2 = ClientProxy.modelManager;
        GL11.glEnable((int)32826);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        this.model = null;
        ItemArmorArtefakt info = null;
        if (player.o(2) != null && player.o(2).b() instanceof ItemArmorArtefakt) {
            info = (ItemArmorArtefakt)((Object)player.o(2).b());
            if (info.specialModelName != null && !info.specialModelName.isEmpty()) {
                m2.tryLoadTexture(info.specialModelTexture);
                m2.tryBindTexture(info.specialModelTexture);
                this.model = m2.getModel("armor", info.specialModelName + "_head." + info.extension);
                if (this.model != null) {
                    GL11.glPushMatrix();
                    this.modelBiped.c.c(0.0625f);
                    GL11.glTranslatef((float)0.0f, (float)(0.01f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.06f + scale), (float)1.04f, (float)(1.06f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_body." + info.extension);
                if (this.model != null) {
                    GL11.glPushMatrix();
                    this.modelBiped.e.c(0.0625f);
                    GL11.glTranslatef((float)0.0f, (float)(-0.01f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.05f + scale), (float)1.11f, (float)(1.05f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_rightarm." + info.extension);
                if (this.model != null && m2.tryBindTexture(info.specialModelTexture)) {
                    GL11.glPushMatrix();
                    this.modelBiped.f.c(0.0625f);
                    GL11.glTranslatef((float)0.337f, (float)(-0.18f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.09f + scale), (float)1.056f, (float)(1.07f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_leftarm." + info.extension);
                if (this.model != null && m2.tryBindTexture(info.specialModelTexture)) {
                    GL11.glPushMatrix();
                    this.modelBiped.g.c(0.0625f);
                    GL11.glTranslatef((float)-0.337f, (float)(-0.18f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.09f + scale), (float)1.056f, (float)(1.07f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_rightleg." + info.extension);
                if (this.model != null && m2.tryBindTexture(info.specialModelTexture)) {
                    GL11.glPushMatrix();
                    this.modelBiped.h.c(0.0625f);
                    GL11.glTranslatef((float)0.132f, (float)(-0.81f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.09f + scale), (float)1.05f, (float)(1.06f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_leftleg." + info.extension);
                if (this.model != null && m2.tryBindTexture(info.specialModelTexture)) {
                    GL11.glPushMatrix();
                    this.modelBiped.i.c(0.0625f);
                    GL11.glTranslatef((float)-0.132f, (float)(-0.81f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.09f + scale), (float)1.05f, (float)(1.06f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_rightboot." + info.extension);
                if (this.model != null) {
                    GL11.glPushMatrix();
                    this.modelBiped.h.c(0.0625f);
                    GL11.glTranslatef((float)0.13f, (float)(-1.3f + translateY), (float)0.0f);
                    GL11.glScalef((float)(1.02f + scale), (float)1.02f, (float)(1.02f + scale));
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
                this.model = m2.getModel("armor", info.specialModelName + "_leftboot." + info.extension);
                if (this.model != null) {
                    GL11.glPushMatrix();
                    this.modelBiped.i.c(0.0625f);
                    GL11.glTranslatef((float)-0.13f, (float)(-1.3f + translateY), (float)0.0f);
                    GL11.glScalef((float)1.02f, (float)1.02f, (float)1.02f);
                    this.model.renderAll();
                    GL11.glPopMatrix();
                }
            }
        }
        GL11.glPushMatrix();
        this.modelBiped.e.c(0.0625f);
        PlayerInfo info1 = PlayerUtils.getInfo(player);
        int backpack = player == atv.w().h ? info1.stInv.getBackpack() : info1.getBackpackId();
        RenderBackpack.renderBackpack(player, backpack);
        if (GuiSettingsStalker.renderEquippedWeapons) {
            this.renderEquippedWeapons(player, backpack != 0);
        }
        GL11.glPopMatrix();
        if (info1.getHandcuffs()) {
            RenderHandcuffs.renderHandcuffsThirdPerson(this.modelBiped);
        }
        GL11.glDisable((int)3042);
    }

    private void renderEquippedWeapons(uf player, boolean backpack) {
        WeaponInfo wi2 = PlayerUtils.getInfo((uf)player).weaponInfo;
        if (wi2.getRifle() != null && ClientProxy.weaponRenders.containsKey(wi2.getRifle().d)) {
            ((RenderWeapon)ClientProxy.weaponRenders.get(wi2.getRifle().d)).renderOnPlayer(player, backpack ? RenderWeapon.RenderType.BACKPACK_RIFLE : RenderWeapon.RenderType.RIFLE, wi2.getRifle());
        }
        if (wi2.getPistol() != null && ClientProxy.weaponRenders.containsKey(wi2.getPistol().d)) {
            ((RenderWeapon)ClientProxy.weaponRenders.get(wi2.getPistol().d)).renderOnPlayer(player, RenderWeapon.RenderType.PISTOL, wi2.getPistol());
        }
    }

    @Override
    public void a(uf player) {
        float f2 = 1.0f;
        GL11.glColor3f((float)f2, (float)f2, (float)f2);
        this.modelBiped.p = 0.0f;
        this.modelBiped.a(0.0f, 0.0f, 0.0f, 0.0f, 90.0f, 0.0625f, player);
        this.modelBiped.f.a(0.0625f);
        ye itemArmor = player.bn.f(2);
        StalkerModelManager m2 = ClientProxy.modelManager;
        this.model = null;
        ItemArmorArtefakt info = null;
        if (player.o(2) != null && player.o(2).b() instanceof ItemArmorArtefakt) {
            info = (ItemArmorArtefakt)((Object)player.o(2).b());
            this.model = m2.getModel("armor", info.specialModelName + "_rightarm." + info.extension);
            if (this.model != null && m2.tryBindTexture(info.specialModelTexture)) {
                GL11.glPushMatrix();
                this.modelBiped.f.c(0.0625f);
                GL11.glTranslatef((float)0.315f, (float)(-0.154f + translateY), (float)0.0f);
                GL11.glScalef((float)(1.022f + scale), (float)1.03f, (float)(1.05f + scale));
                this.model.renderAll();
                GL11.glPopMatrix();
            }
        }
    }

    @Override
    public void c(of par1EntityLiving, float par2) {
        super.c(par1EntityLiving, par2);
        this.renderStalkerArmor((uf)par1EntityLiving, par2);
    }

    @Override
    public void a(beu par1AbstractClientPlayer, double par2, double par4, double par6, float par8, float par9) {
        if (!par1AbstractClientPlayer.M && par1AbstractClientPlayer.aN() > 0.0f) {
            GL11.glPushMatrix();
            if (((PlayerClientInfo)PlayerUtils.getInfo((uf)par1AbstractClientPlayer)).hasQuitted) {
                GL11.glTranslatef((float)0.0f, (float)-0.6f, (float)0.0f);
            }
            super.a(par1AbstractClientPlayer, par2, par4, par6, par8, par9);
            GL11.glPopMatrix();
        }
    }
}

