/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.StalcraftMod;
import com.stalcraft.blocks.StalcraftBlock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.sajh;

public class BlockFenceCorner
extends twgu
implements StalcraftBlock {
    public BlockFenceCorner(int n, tflj tflj2) {
        super(n, tflj2);
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        String string = "stalcraft:fence";
        this.func_111022_d(string);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 2.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public int func_71857_b() {
        return StalcraftMod.fenceCornerRenderId;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }
}

