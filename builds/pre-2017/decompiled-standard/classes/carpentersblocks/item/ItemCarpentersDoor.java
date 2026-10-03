/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.item;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockCarpentersDoor;
import carpentersblocks.data.Door;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class ItemCarpentersDoor
extends tgdv {
    public ItemCarpentersDoor(int n) {
        super(n);
        this.field_77777_bU = 64;
        this.func_77655_b("itemCarpentersDoor");
        this.func_77637_a(CarpentersBlocks.tabCarpentersBlocks);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("carpentersblocks:door");
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (n4 != 1) {
            return false;
        }
        BlockCarpentersDoor blockCarpentersDoor = (BlockCarpentersDoor)BlockHandler.blockCarpentersDoor;
        if (entityPlayer.func_82247_a(n, ++n2, n3, n4, cvzo2) && entityPlayer.func_82247_a(n, n2 + 1, n3, n4, cvzo2)) {
            if (!blockCarpentersDoor.func_71930_b(ozlu2, n, n2, n3)) {
                return false;
            }
            int n5 = sajh._c((double)((entityPlayer.field_70177_z + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
            this.placeDoorBlock(ozlu2, n, n2, n3, n5, blockCarpentersDoor);
            --cvzo2._b;
            return true;
        }
        return false;
    }

    private void placeDoorBlock(ozlu ozlu2, int n, int n2, int n3, int n4, twgu twgu2) {
        ozlu2.func_94575_c(n, n2, n3, twgu2.field_71990_ca);
        BlockProperties.playBlockPlacementSound(ozlu2, n, n2, n3, BlockHandler.blockCarpentersDoorID);
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        Door.setFacing(tECarpentersBlock, n4);
        Door.setHingeSide(tECarpentersBlock, this.getHingePoint(tECarpentersBlock, twgu2.field_71990_ca));
        Door.setPiece(tECarpentersBlock, 0);
        TECarpentersBlock tECarpentersBlock2 = ozlu2.func_72798_a(n - 1, n2, n3) == twgu2.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n - 1, n2, n3) : null;
        TECarpentersBlock tECarpentersBlock3 = ozlu2.func_72798_a(n + 1, n2, n3) == twgu2.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n + 1, n2, n3) : null;
        TECarpentersBlock tECarpentersBlock4 = ozlu2.func_72798_a(n, n2, n3 - 1) == twgu2.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 - 1) : null;
        TECarpentersBlock tECarpentersBlock5 = ozlu2.func_72798_a(n, n2, n3 + 1) == twgu2.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 + 1) : null;
        int n5 = 0;
        if (tECarpentersBlock2 != null) {
            int n6 = BlockProperties.getData(tECarpentersBlock2);
            Door.setType(tECarpentersBlock, Door.getType(n6));
            Door.setRigidity(tECarpentersBlock, Door.getRigidity(n6));
            n5 = Door.getType(n6);
        } else if (tECarpentersBlock3 != null) {
            int n7 = BlockProperties.getData(tECarpentersBlock3);
            Door.setType(tECarpentersBlock, Door.getType(n7));
            Door.setRigidity(tECarpentersBlock, Door.getRigidity(n7));
            n5 = Door.getType(n7);
        } else if (tECarpentersBlock4 != null) {
            int n8 = BlockProperties.getData(tECarpentersBlock4);
            Door.setType(tECarpentersBlock, Door.getType(n8));
            Door.setRigidity(tECarpentersBlock, Door.getRigidity(n8));
            n5 = Door.getType(n8);
        } else if (tECarpentersBlock5 != null) {
            int n9 = BlockProperties.getData(tECarpentersBlock5);
            Door.setType(tECarpentersBlock, Door.getType(n9));
            Door.setRigidity(tECarpentersBlock, Door.getRigidity(n9));
            n5 = Door.getType(n9);
        }
        ozlu2.func_94575_c(n, n2 + 1, n3, twgu2.field_71990_ca);
        TECarpentersBlock tECarpentersBlock6 = (TECarpentersBlock)ozlu2.func_72796_p(n, n2 + 1, n3);
        Door.setFacing(tECarpentersBlock6, n4);
        Door.setType(tECarpentersBlock6, n5);
        Door.setHingeSide(tECarpentersBlock6, Door.getHinge(BlockProperties.getData(tECarpentersBlock)));
        Door.setPiece(tECarpentersBlock6, 1);
        Door.setRigidity(tECarpentersBlock6, Door.getRigidity(BlockProperties.getData(tECarpentersBlock)));
    }

    private int getHingePoint(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = Door.getFacing(n2);
        Door.getHinge(n2);
        Door.getState(n2);
        int n4 = Door.getPiece(n2);
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n - 1) == n ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n - 1) : null;
        TECarpentersBlock tECarpentersBlock3 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n + 1) == n ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n + 1) : null;
        TECarpentersBlock tECarpentersBlock4 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) == n ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) : null;
        TECarpentersBlock tECarpentersBlock5 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) == n ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) : null;
        switch (n3) {
            case 0: {
                int n5;
                if (tECarpentersBlock2 == null || n4 != Door.getPiece(n5 = BlockProperties.getData(tECarpentersBlock2)) || n3 != Door.getFacing(n5) || Door.getHinge(n5) != 0) break;
                return 1;
            }
            case 1: {
                int n6;
                if (tECarpentersBlock5 == null || n4 != Door.getPiece(n6 = BlockProperties.getData(tECarpentersBlock5)) || n3 != Door.getFacing(n6) || Door.getHinge(n6) != 0) break;
                return 1;
            }
            case 2: {
                int n7;
                if (tECarpentersBlock3 == null || n4 != Door.getPiece(n7 = BlockProperties.getData(tECarpentersBlock3)) || n3 != Door.getFacing(n7) || Door.getHinge(n7) != 0) break;
                return 1;
            }
            case 3: {
                int n8;
                if (tECarpentersBlock4 == null || n4 != Door.getPiece(n8 = BlockProperties.getData(tECarpentersBlock4)) || n3 != Door.getFacing(n8) || Door.getHinge(n8) != 0) break;
                return 1;
            }
        }
        return 0;
    }
}

