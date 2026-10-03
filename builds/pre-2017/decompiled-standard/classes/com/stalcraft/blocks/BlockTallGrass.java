/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.StalcraftMod;
import com.stalcraft.blocks.StalcraftBlock;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;

public class BlockTallGrass
extends twgu
implements StalcraftBlock {
    public dwan topIcon;
    public dwan bottomIcon;

    public BlockTallGrass(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.topIcon = nege2._b("stalcraft:grass_top");
        this.bottomIcon = nege2._b("stalcraft:grass_bottom");
        this.field_94336_cN = this.topIcon;
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
    public int func_71857_b() {
        return StalcraftMod.grassRenderId;
    }
}

