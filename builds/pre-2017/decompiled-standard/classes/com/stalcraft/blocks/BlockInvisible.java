/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.blocks.StalcraftBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;

public class BlockInvisible
extends twgu
implements StalcraftBlock {
    private dwan creativeIcon;

    public BlockInvisible(int n, tflj tflj2) {
        super(n, tflj2);
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
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalcraft:inv");
        this.creativeIcon = nege2._b("stalcraft:inv_wall");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.field_94336_cN;
        }
        return this.creativeIcon;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public boolean canRenderInPass(int n) {
        return super.canRenderInPass(n) && this.func_71857_b() != -1;
    }

    @Override
    public int func_71857_b() {
        return GloomyCore.transparentsRenderType;
    }
}

