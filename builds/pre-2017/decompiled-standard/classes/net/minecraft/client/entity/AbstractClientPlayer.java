/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import gloomyfolken.mods.skinarmor.eidj;
import mcoptifine.Config;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.eifc;

public abstract class AbstractClientPlayer
extends EntityPlayer {
    public static final ResourceLocation field_110314_b = new ResourceLocation("textures/entity/steve.png");
    public rqrn field_110316_a;
    public rqrn field_110315_c;
    public ResourceLocation field_110312_d;
    public ResourceLocation field_110313_e;

    public AbstractClientPlayer(ozlu ozlu2, String string) {
        super(ozlu2, string);
        this.func_110302_j();
    }

    public void func_110302_j() {
        System.out.println("Setting up custom skins");
        if (this.field_71092_bJ != null && !this.field_71092_bJ.isEmpty()) {
            this.field_110312_d = AbstractClientPlayer.func_110311_f(this.field_71092_bJ);
            this.field_110313_e = AbstractClientPlayer.func_110299_g(this.field_71092_bJ);
            this.field_110316_a = AbstractClientPlayer.func_110304_a(this.field_110312_d, this.field_71092_bJ);
            this.field_110315_c = AbstractClientPlayer.func_110307_b(this.field_110313_e, this.field_71092_bJ);
            this.field_110315_c._g = Config.isShowCapes();
        }
    }

    public rqrn func_110309_l() {
        return this.field_110316_a;
    }

    public rqrn func_110310_o() {
        return this.field_110315_c;
    }

    public ResourceLocation func_110306_p() {
        ResourceLocation resourceLocation = eidj._a(this);
        return resourceLocation;
    }

    public ResourceLocation func_110303_q() {
        return this.field_110313_e;
    }

    public static rqrn func_110304_a(ResourceLocation resourceLocation, String string) {
        return AbstractClientPlayer.func_110301_a(resourceLocation, AbstractClientPlayer.func_110300_d(string), field_110314_b, new scss());
    }

    public static rqrn func_110307_b(ResourceLocation resourceLocation, String string) {
        return AbstractClientPlayer.func_110301_a(resourceLocation, AbstractClientPlayer.func_110308_e(string), null, null);
    }

    public static rqrn func_110301_a(ResourceLocation resourceLocation, String string, ResourceLocation resourceLocation2, xbbs xbbs2) {
        apbu apbu2 = xpzm._E()._R();
        sctg sctg2 = apbu2._b(resourceLocation);
        if (sctg2 == null) {
            sctg2 = new rqrn(string, resourceLocation2, xbbs2);
            apbu2._a(resourceLocation, sctg2);
        }
        return (rqrn)sctg2;
    }

    public static String func_110300_d(String string) {
        return String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", eifc._a(string));
    }

    public static String func_110308_e(String string) {
        return String.format("http://skins.minecraft.net/MinecraftCloaks/%s.png", eifc._a(string));
    }

    public static ResourceLocation func_110311_f(String string) {
        return new ResourceLocation("skins/" + eifc._a(string));
    }

    public static ResourceLocation func_110299_g(String string) {
        return new ResourceLocation("cloaks/" + eifc._a(string));
    }

    public static ResourceLocation func_110305_h(String string) {
        return new ResourceLocation("skull/" + eifc._a(string));
    }
}

