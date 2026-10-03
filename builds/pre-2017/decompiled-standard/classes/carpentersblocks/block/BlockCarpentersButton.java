/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Button;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersButton
extends BlockBase {
    public BlockCarpentersButton(int n) {
        super(n, tflj._q);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersButton");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_71907_b(true);
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = Button.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            Button.setPolarity(tECarpentersBlock, n);
            this.notifySideNeighbor(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n, Button.getType(n2));
        } else {
            switch (n) {
                case 0: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.polarity_pos.name"));
                    break;
                }
                case 1: {
                    entityPlayer.func_71035_c(LanguageRegistry.instance().getStringLocalization("message.polarity_neg.name"));
                }
            }
        }
        return true;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 20;
    }

    @Override
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        return forgeDirection == ForgeDirection.NORTH && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || forgeDirection == ForgeDirection.SOUTH && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || forgeDirection == ForgeDirection.WEST && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || forgeDirection == ForgeDirection.EAST && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        n5 &= 7;
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        n5 = forgeDirection == ForgeDirection.NORTH && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) ? 4 : (forgeDirection == ForgeDirection.SOUTH && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) ? 3 : (forgeDirection == ForgeDirection.WEST && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) ? 2 : (forgeDirection == ForgeDirection.EAST && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) ? 1 : this.getOrientation(ozlu2, n, n2, n3))));
        return n5;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        Button.setType(tECarpentersBlock, ozlu2.func_72805_g(n, n2, n3));
    }

    private int getOrientation(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) ? 1 : (ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) ? 2 : (ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) ? 3 : (ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) ? 4 : 1)));
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Button.getType(n5);
        boolean bl = true;
        if (this.func_71930_b(ozlu2, n, n2, n3)) {
            if (ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n6 == 1) {
                bl = false;
            }
            if (ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n6 == 2) {
                bl = false;
            }
            if (ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n6 == 3) {
                bl = false;
            }
            if (ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n6 == 4) {
                bl = false;
            }
        }
        if (bl) {
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Button.getType(n4);
        float f = this.isDepressed(tECarpentersBlock) ? 0.0625f : 0.125f;
        switch (n5) {
            case 1: {
                this.func_71905_a(0.0f, 0.375f, 0.3125f, f, 0.625f, 0.6875f);
                break;
            }
            case 2: {
                this.func_71905_a(1.0f - f, 0.375f, 0.3125f, 1.0f, 0.625f, 0.6875f);
                break;
            }
            case 3: {
                this.func_71905_a(0.3125f, 0.375f, 0.0f, 0.6875f, 0.625f, f);
                break;
            }
            case 4: {
                this.func_71905_a(0.3125f, 0.375f, 1.0f - f, 0.6875f, 0.625f, 1.0f);
            }
        }
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Button.getType(n5);
        if (!this.isDepressed(tECarpentersBlock)) {
            Button.setState(tECarpentersBlock, 1, true);
            this.notifySideNeighbor(ozlu2, n, n2, n3, n6);
            ozlu2.func_72836_a(n, n2, n3, this.field_71990_ca, this.func_71859_p_(ozlu2));
            return true;
        }
        return false;
    }

    @Override
    public void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        int n6 = BlockProperties.getData(tECarpentersBlock);
        int n7 = Button.getType(n6);
        if (this.isDepressed(tECarpentersBlock)) {
            this.notifySideNeighbor(ozlu2, n, n2, n3, n7);
        }
    }

    private boolean isDepressed(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        return Button.getState(n) == 1;
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        return this.getPowerSupply(tECarpentersBlock, n5);
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Button.getType(n5);
        return n6 == 5 && n4 == 1 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 4 && n4 == 2 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 3 && n4 == 3 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 2 && n4 == 4 ? this.getPowerSupply(tECarpentersBlock, n5) : (n6 == 1 && n4 == 5 ? this.getPowerSupply(tECarpentersBlock, n5) : 0))));
    }

    private int getPowerSupply(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = Button.getPolarity(n);
        return this.isDepressed(tECarpentersBlock) ? (n2 == 0 ? 15 : 0) : (n2 == 1 ? 15 : 0);
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (!ozlu2.field_72995_K) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
            int n4 = BlockProperties.getData(tECarpentersBlock);
            int n5 = Button.getType(n4);
            Button.setState(tECarpentersBlock, 0, true);
            this.notifySideNeighbor(ozlu2, n, n2, n3, n5);
        }
    }

    private void notifySideNeighbor(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        switch (n4) {
            case 1: {
                ozlu2.func_72898_h(n - 1, n2, n3, this.field_71990_ca);
                break;
            }
            case 2: {
                ozlu2.func_72898_h(n + 1, n2, n3, this.field_71990_ca);
                break;
            }
            case 3: {
                ozlu2.func_72898_h(n, n2, n3 - 1, this.field_71990_ca);
                break;
            }
            case 4: {
                ozlu2.func_72898_h(n, n2, n3 + 1, this.field_71990_ca);
                break;
            }
            default: {
                ozlu2.func_72898_h(n, n2 - 1, n3, this.field_71990_ca);
            }
        }
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersButtonRenderID;
    }
}

