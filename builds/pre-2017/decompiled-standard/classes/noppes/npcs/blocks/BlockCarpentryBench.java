/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.blocks.TileBlockAnvil;
import noppes.npcs.constants.EnumGuiType;

public class BlockCarpentryBench
extends iwgt {
    public BlockCarpentryBench(int n) {
        super(n, tflj._f);
        this.func_71849_a(CustomItems.tab);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K) {
            entityPlayer.openGui(CustomNpcs.instance, EnumGuiType.PlayerAnvil.ordinal(), ozlu2, n, n2, n3);
        }
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new TileBlockAnvil();
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return -1;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z / 90.0f) + 0.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }
}

