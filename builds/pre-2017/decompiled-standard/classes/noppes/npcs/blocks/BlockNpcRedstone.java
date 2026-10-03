/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.blocks.BlockTransparentContainer;
import noppes.npcs.blocks.TileRedstoneBlock;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;

public class BlockNpcRedstone
extends BlockTransparentContainer {
    public BlockNpcRedstone(int n) {
        super(n, tflj._q);
        this.func_71849_a(CustomItems.tab);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return false;
        }
        if (entityPlayer.field_71075_bZ._d) {
            hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
            qoac qoac2 = new qoac();
            hurg2.func_70310_b(qoac2);
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.RedstoneBlockSave, qoac2);
            return true;
        }
        return false;
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
        ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
        ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        if (entityLivingBase instanceof EntityPlayer && ozlu2.field_72995_K) {
            CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.RedstoneBlock, (EntityPlayer)entityLivingBase);
        }
    }

    @Override
    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this.func_71861_g(ozlu2, n, n2, n3);
    }

    @Override
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        return this.isActivated(sdrg2, n, n2, n3) > 0 ? 16739176 : super.func_71920_b(sdrg2, n, n2, n3);
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this.isActivated(sdrg2, n, n2, n3);
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return this.isActivated(sdrg2, n, n2, n3);
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new TileRedstoneBlock();
    }

    public int isActivated(sdrg sdrg2, int n, int n2, int n3) {
        return sdrg2.func_72805_g(n, n2, n3) == 1 ? 15 : 0;
    }
}

