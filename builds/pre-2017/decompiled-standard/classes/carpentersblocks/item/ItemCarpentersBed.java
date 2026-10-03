/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.item;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.data.Bed;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class ItemCarpentersBed
extends tgdv {
    public ItemCarpentersBed(int n) {
        super(n);
        this.field_77777_bU = 64;
        this.func_77655_b("itemCarpentersBed");
        this.func_77637_a(CarpentersBlocks.tabCarpentersBlocks);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("carpentersblocks:bed");
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!ozlu2.field_72995_K && n4 == 1) {
            int n5 = sajh._c((double)(entityPlayer.field_70177_z * 4.0f / 360.0f) + 0.5) & 3;
            ForgeDirection forgeDirection = Bed.getDirection(n5);
            int n6 = n - forgeDirection.offsetX;
            int n7 = n3 - forgeDirection.offsetZ;
            if (entityPlayer.func_82247_a(n, ++n2, n3, n4, cvzo2) && entityPlayer.func_82247_a(n6, n2, n7, n4, cvzo2)) {
                if (ozlu2.func_72799_c(n, n2, n3) && ozlu2.func_72799_c(n6, n2, n7) && ozlu2.func_72797_t(n, n2 - 1, n3) && ozlu2.func_72797_t(n6, n2 - 1, n7)) {
                    ozlu2.func_72832_d(n, n2, n3, BlockHandler.blockCarpentersBedID, n5, 3);
                    ozlu2.func_72832_d(n6, n2, n7, BlockHandler.blockCarpentersBedID, n5 + 8, 3);
                    BlockProperties.playBlockPlacementSound(ozlu2, n, n2, n3, BlockHandler.blockCarpentersBedID);
                    --cvzo2._b;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}

