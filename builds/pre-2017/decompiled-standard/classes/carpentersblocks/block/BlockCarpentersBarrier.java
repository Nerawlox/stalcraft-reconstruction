/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Barrier;
import carpentersblocks.data.Gate;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersBarrier
extends BlockBase {
    public BlockCarpentersBarrier(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersBarrier");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        Barrier.setPost(tECarpentersBlock, Barrier.getPost(n) == 1 ? 0 : 1);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = Barrier.getType(n2);
        if (entityPlayer.func_70093_af()) {
            if (n3 <= 3 && ++n3 > 3) {
                n3 = 0;
            }
        } else if (n3 <= 3) {
            n3 = 4;
        } else if (++n3 > 6) {
            n3 = 0;
        }
        Barrier.setType(tECarpentersBlock, n3);
        return true;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        TECarpentersBlock tECarpentersBlock2;
        TECarpentersBlock tECarpentersBlock3 = ozlu2.func_72798_a(n, n2 - 1, n3) != this.field_71990_ca && ozlu2.func_72798_a(n, n2 - 1, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)ozlu2.func_72796_p(n, n2 - 1, n3);
        TECarpentersBlock tECarpentersBlock4 = ozlu2.func_72798_a(n, n2 + 1, n3) != this.field_71990_ca && ozlu2.func_72798_a(n, n2 + 1, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)ozlu2.func_72796_p(n, n2 + 1, n3);
        TECarpentersBlock tECarpentersBlock5 = ozlu2.func_72798_a(n - 1, n2, n3) != this.field_71990_ca && ozlu2.func_72798_a(n - 1, n2, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)ozlu2.func_72796_p(n - 1, n2, n3);
        TECarpentersBlock tECarpentersBlock6 = ozlu2.func_72798_a(n + 1, n2, n3) != this.field_71990_ca && ozlu2.func_72798_a(n + 1, n2, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)ozlu2.func_72796_p(n + 1, n2, n3);
        TECarpentersBlock tECarpentersBlock7 = ozlu2.func_72798_a(n, n2, n3 - 1) != this.field_71990_ca && ozlu2.func_72798_a(n, n2, n3 - 1) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 - 1);
        TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = ozlu2.func_72798_a(n, n2, n3 + 1) != this.field_71990_ca && ozlu2.func_72798_a(n, n2, n3 + 1) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3 + 1);
        if (tECarpentersBlock3 != null) {
            int n4 = BlockProperties.getData(tECarpentersBlock3);
            Barrier.setType(tECarpentersBlock, ozlu2.func_72798_a(n, n2 - 1, n3) == this.field_71990_ca ? Barrier.getType(n4) : Gate.getType(n4));
        } else if (tECarpentersBlock4 != null) {
            int n5 = BlockProperties.getData(tECarpentersBlock4);
            Barrier.setType(tECarpentersBlock, ozlu2.func_72798_a(n, n2 + 1, n3) == this.field_71990_ca ? Barrier.getType(n5) : Gate.getType(n5));
        } else if (tECarpentersBlock5 != null) {
            int n6 = BlockProperties.getData(tECarpentersBlock5);
            Barrier.setType(tECarpentersBlock, ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca ? Barrier.getType(n6) : Gate.getType(n6));
        } else if (tECarpentersBlock6 != null) {
            int n7 = BlockProperties.getData(tECarpentersBlock6);
            Barrier.setType(tECarpentersBlock, ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca ? Barrier.getType(n7) : Gate.getType(n7));
        } else if (tECarpentersBlock7 != null) {
            int n8 = BlockProperties.getData(tECarpentersBlock7);
            Barrier.setType(tECarpentersBlock, ozlu2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca ? Barrier.getType(n8) : Gate.getType(n8));
        } else if (tECarpentersBlock2 != null) {
            int n9 = BlockProperties.getData(tECarpentersBlock2);
            Barrier.setType(tECarpentersBlock, ozlu2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca ? Barrier.getType(n9) : Gate.getType(n9));
        }
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
        boolean bl = this.canConnectBarrierTo(tECarpentersBlock, ozlu2, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl2 = this.canConnectBarrierTo(tECarpentersBlock, ozlu2, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl3 = this.canConnectBarrierTo(tECarpentersBlock, ozlu2, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl4 = this.canConnectBarrierTo(tECarpentersBlock, ozlu2, n + 1, n2, n3, ForgeDirection.WEST);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl || bl2) {
            this.func_71905_a(f, 0.0f, f3, f2, 1.5f, f4);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
        f3 = 0.375f;
        f4 = 0.625f;
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        if (bl3 || bl4 || !bl && !bl2) {
            this.func_71905_a(f, 0.0f, f3, f2, 1.5f, f4);
            super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
        }
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        this.func_71905_a(f, 0.0f, f3, f2, 1.0f, f4);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n4 = Barrier.getType(BlockProperties.getData(tECarpentersBlock));
        boolean bl = this.canConnectBarrierTo(tECarpentersBlock, sdrg2, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl2 = this.canConnectBarrierTo(tECarpentersBlock, sdrg2, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl3 = this.canConnectBarrierTo(tECarpentersBlock, sdrg2, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl4 = this.canConnectBarrierTo(tECarpentersBlock, sdrg2, n + 1, n2, n3, ForgeDirection.WEST);
        float f = 0.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (n4 <= 3) {
            f = 0.375f;
            f2 = 0.625f;
            f3 = 0.375f;
            f4 = 0.625f;
            if (bl) {
                f3 = 0.0f;
            }
            if (bl2) {
                f4 = 1.0f;
            }
            if (bl3) {
                f = 0.0f;
            }
            if (bl4) {
                f2 = 1.0f;
            }
        } else {
            f = 0.25f;
            f2 = 0.75f;
            f3 = 0.25f;
            f4 = 0.75f;
            if (bl) {
                f3 = 0.0f;
            }
            if (bl2) {
                f4 = 1.0f;
            }
            if (bl3) {
                f = 0.0f;
            }
            if (bl4) {
                f2 = 1.0f;
            }
            if (bl && bl2 && !bl3 && !bl4) {
                f = 0.3125f;
                f2 = 0.6875f;
            } else if (!bl && !bl2 && bl3 && bl4) {
                f3 = 0.3125f;
                f4 = 0.6875f;
            }
        }
        this.func_71905_a(f, 0.0f, f3, f2, 1.0f, f4);
    }

    public boolean canConnectBarrierTo(TECarpentersBlock tECarpentersBlock, sdrg sdrg2, int n, int n2, int n3, ForgeDirection forgeDirection) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        if (n5 > 0) {
            twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
            if (forgeDirection != ForgeDirection.UP) {
                if (sdrg2.func_72798_a(n, n2, n3) != this.field_71990_ca && n5 != BlockHandler.blockCarpentersGateID) {
                    return twgu2.isBlockSolidOnSide(tECarpentersBlock.field_70331_k, n, n2, n3, forgeDirection) && Barrier.getPost(n4) != 1;
                }
                return true;
            }
            if (twgu2 != null && twgu2.field_72018_cp == tflj._q) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canPlaceTorchOnTop(ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersBarrierRenderID;
    }
}

