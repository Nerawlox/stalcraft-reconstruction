/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.block.BlockCarpentersBlock;
import carpentersblocks.block.BlockCarpentersStairs;
import carpentersblocks.data.Hatch;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersHatch
extends BlockBase {
    public BlockCarpentersHatch(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersHatch");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        BlockProperties.getData(tECarpentersBlock);
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            this.findNextSideSupportBlock(tECarpentersBlock, tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        }
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        if (!entityPlayer.func_70093_af()) {
            if (!tECarpentersBlock.field_70331_k.field_72995_K) {
                int n3 = Hatch.getType(n2);
                if (++n3 > 4) {
                    n3 = 0;
                }
                Hatch.setType(tECarpentersBlock, n3);
            }
        } else {
            int n4;
            int n5 = n4 = Hatch.getRigidity(n2) == 0 ? 1 : 0;
            if (!tECarpentersBlock.field_70331_k.field_72995_K) {
                Hatch.setRigidity(tECarpentersBlock, n4);
            } else {
                switch (n4) {
                    case 0: {
                        entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.activation_wood.name"));
                        break;
                    }
                    case 1: {
                        entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.activation_iron.name"));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        if (!this.activationRequiresRedstone(tECarpentersBlock, n5)) {
            Hatch.setState(tECarpentersBlock, Hatch.getState(n5) == 0 ? 1 : 0);
        }
        return true;
    }

    private boolean activationRequiresRedstone(TECarpentersBlock tECarpentersBlock, int n) {
        return Hatch.getRigidity(n) == 1;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        boolean bl = Hatch.getPos(n4) == 1;
        boolean bl2 = Hatch.getState(n4) == 1;
        int n5 = Hatch.getDir(n4);
        if (bl) {
            this.func_71905_a(0.0f, 0.8125f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.1875f, 1.0f);
        }
        if (bl2) {
            switch (n5) {
                case 0: {
                    this.func_71905_a(0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f);
                    break;
                }
                case 2: {
                    this.func_71905_a(0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.func_71905_a(0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f);
                }
            }
        }
    }

    @Override
    public void func_71871_a(ozlu ozlu2, int n, int n2, int n3, eidj eidj2, List list2, Entity entity) {
        this.func_71902_a(ozlu2, n, n2, n3);
        super.func_71871_a(ozlu2, n, n2, n3, eidj2, list2, entity);
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        int n7 = Hatch.getState(n5);
        int n8 = n;
        int n9 = n3;
        switch (n6) {
            case 0: {
                n9 = n3 + 1;
                break;
            }
            case 1: {
                n9 = n3 - 1;
                break;
            }
            case 2: {
                n8 = n + 1;
                break;
            }
            case 3: {
                n8 = n - 1;
            }
        }
        if (!this.isValidSupportBlock(ozlu2, n, n2, n3, ozlu2.func_72798_a(n8, n2, n9), n6 + 2) && !ozlu2.isBlockSolidOnSide(n8, n2, n9, ForgeDirection.getOrientation(n6 + 2))) {
            this.findNextSideSupportBlock(tECarpentersBlock, ozlu2, n, n2, n3);
        }
        boolean bl2 = ozlu2.func_72864_z(n, n2, n3);
        boolean bl3 = bl = n7 == 1;
        if (n4 > 0 && twgu.field_71973_m[n4].func_71853_i() && bl2 != bl) {
            Hatch.setState(tECarpentersBlock, n7 == 1 ? 0 : 1);
        }
    }

    @Override
    public hank func_71878_a(ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        this.func_71902_a(ozlu2, n, n2, n3);
        return super.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        if (n4 > 1) {
            n6 = n4 - 2;
        }
        if (n4 != 1 && n4 != 0 && f2 > 0.5f) {
            n6 |= 8;
        }
        return n6;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        boolean bl;
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        Hatch.setDir(tECarpentersBlock, n4 & 3);
        boolean bl2 = bl = (n4 & 8) > 0;
        if (bl) {
            Hatch.setPos(tECarpentersBlock, 1);
        }
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        switch (n4) {
            case 2: {
                return this.isValidSupportBlock(ozlu2, n, n2, n3, ozlu2.func_72798_a(n, n2, n3 + 1), 3) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[3]));
            }
            case 3: {
                return this.isValidSupportBlock(ozlu2, n, n2, n3, ozlu2.func_72798_a(n, n2, n3 - 1), 2) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[2]));
            }
            case 4: {
                return this.isValidSupportBlock(ozlu2, n, n2, n3, ozlu2.func_72798_a(n + 1, n2, n3), 5) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[5]));
            }
            case 5: {
                return this.isValidSupportBlock(ozlu2, n, n2, n3, ozlu2.func_72798_a(n - 1, n2, n3), 4) || ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[4]));
            }
        }
        return false;
    }

    private void findNextSideSupportBlock(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        if (++n6 > 3) {
            n6 = 0;
        }
        for (n4 = 0; !this.func_71850_a_(ozlu2, n, n2, n3, n6 + 2) && n4 < 4; ++n4) {
            if (++n6 <= 3) continue;
            n6 = 0;
        }
        if (n4 == 4) {
            ozlu2.func_94571_i(n, n2, n3);
        } else {
            Hatch.setDir(tECarpentersBlock, n6);
        }
    }

    private boolean isValidSupportBlock(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        twgu twgu2 = twgu.field_71973_m[n4];
        return twgu2 == twgu.field_72014_bd || twgu2 instanceof BlockCarpentersStairs || twgu2 instanceof BlockCarpentersBlock || twgu2 instanceof ndvn || twgu2 instanceof yuxu;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersHatchRenderID;
    }
}

