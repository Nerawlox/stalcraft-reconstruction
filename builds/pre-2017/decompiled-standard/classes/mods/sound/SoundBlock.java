/*
 * Decompiled with CFR 0.152.
 */
package mods.sound;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class SoundBlock
extends twgu {
    private dwan visible;

    public SoundBlock(int n) {
        super(n, tflj._c);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super.func_71860_a(ozlu2, n, n2, n3, entityLivingBase, cvzo2);
        if (entityLivingBase instanceof EntityPlayer) {
            InvokeSideOnly.frontend(!ozlu2.field_72995_K, () -> {});
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        InvokeSideOnly.frontend(!ozlu2.field_72995_K, () -> {});
        return super.func_71903_a(ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
    }

    @Override
    public void func_71927_h(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super.func_71927_h(ozlu2, n, n2, n3, n4);
        InvokeSideOnly.frontend(!ozlu2.field_72995_K, () -> {});
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalkersounds:soundblock_inv");
        this.visible = nege2._b("stalkersounds:soundblock_vis");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.field_94336_cN;
        }
        return this.visible;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public int func_71857_b() {
        return GloomyCore.transparentsRenderType;
    }
}

