/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Lever;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersLever
extends BlockBase {
    public BlockCarpentersLever(int n) {
        super(n, tflj._q);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersLever");
        this.func_71849_a(CarpentersBlocks.tabCarpentersBlocks);
        this.func_111022_d("carpentersblocks:lever/lever");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = Lever.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.field_70331_k.field_72995_K) {
            Lever.setPolarity(tECarpentersBlock, n);
            this.notifySideNeighbor(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n, Lever.getType(n2));
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
    public boolean func_71850_a_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
        return forgeDirection == ForgeDirection.DOWN && ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) || forgeDirection == ForgeDirection.UP && ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) || forgeDirection == ForgeDirection.NORTH && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || forgeDirection == ForgeDirection.SOUTH && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || forgeDirection == ForgeDirection.WEST && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || forgeDirection == ForgeDirection.EAST && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) || ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) || ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) || ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) || ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) || ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN);
    }

    @Override
    public int func_85104_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = -1;
        if (n4 == 0 && ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN)) {
            n6 = 0;
        }
        if (n4 == 1 && ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP)) {
            n6 = 5;
        }
        if (n4 == 2 && ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH)) {
            n6 = 4;
        }
        if (n4 == 3 && ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH)) {
            n6 = 3;
        }
        if (n4 == 4 && ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST)) {
            n6 = 2;
        }
        if (n4 == 5 && ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST)) {
            n6 = 1;
        }
        return n6;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        BlockProperties.setData(tECarpentersBlock, ozlu2.func_72805_g(n, n2, n3));
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Lever.getType(n4);
        if (n5 == BlockCarpentersLever.invertType(1)) {
            if ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                Lever.setType(tECarpentersBlock, 5);
            } else {
                Lever.setType(tECarpentersBlock, 6);
            }
        } else if (n5 == BlockCarpentersLever.invertType(0)) {
            if ((sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 0.5) & 1) == 0) {
                Lever.setType(tECarpentersBlock, 7);
            } else {
                Lever.setType(tECarpentersBlock, 0);
            }
        }
    }

    public static int invertType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 5;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 1;
            }
        }
        return -1;
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (this.checkIfAttachedToBlock(ozlu2, n, n2, n3)) {
            boolean bl;
            int n5 = BlockProperties.getData(tECarpentersBlock);
            int n6 = Lever.getType(n5);
            boolean bl2 = bl = !ozlu2.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.EAST) && n6 == 1 || !ozlu2.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.WEST) && n6 == 2 || !ozlu2.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.SOUTH) && n6 == 3 || !ozlu2.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.NORTH) && n6 == 4 || !ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n6 == 5 || !ozlu2.isBlockSolidOnSide(n, n2 - 1, n3, ForgeDirection.UP) && n6 == 6 || !ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n6 == 0 || !ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN) && n6 == 7;
            if (bl) {
                ozlu2.func_94571_i(n, n2, n3);
            }
        }
    }

    private boolean checkIfAttachedToBlock(ozlu ozlu2, int n, int n2, int n3) {
        if (!this.func_71930_b(ozlu2, n, n2, n3)) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3);
            int n4 = BlockProperties.getData(tECarpentersBlock);
            int n5 = Lever.getType(n4);
            ozlu2.func_94571_i(n, n2, n3);
            return false;
        }
        return true;
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Lever.getType(n4);
        float f = 0.1875f;
        switch (n5) {
            case 0: {
                f = 0.25f;
                this.func_71905_a(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
                break;
            }
            case 1: {
                this.func_71905_a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
                break;
            }
            case 2: {
                this.func_71905_a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
                break;
            }
            case 3: {
                this.func_71905_a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
                break;
            }
            case 4: {
                this.func_71905_a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
                break;
            }
            default: {
                f = 0.25f;
                this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
                break;
            }
            case 7: {
                f = 0.25f;
                this.func_71905_a(0.5f - f, 0.4f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
            }
        }
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Lever.getType(n5);
        Lever.setState(tECarpentersBlock, this.isActive(tECarpentersBlock) ? 0 : 1, true);
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        switch (n6) {
            case 0: {
                ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
                break;
            }
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
                break;
            }
            case 7: {
                ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
            }
        }
        return true;
    }

    private boolean isActive(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        return Lever.getState(n) == 1;
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
        int n6 = Lever.getType(n5);
        return !(n6 == 0 && n4 == 0 || n6 == 7 && n4 == 0 || n6 == 6 && n4 == 1 || n6 == 5 && n4 == 1 || n6 == 4 && n4 == 2 || n6 == 3 && n4 == 3 || n6 == 2 && n4 == 4 || n6 == 1 && n4 == 5) ? 0 : this.getPowerSupply(tECarpentersBlock, n5);
    }

    private int getPowerSupply(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = Lever.getPolarity(n);
        return this.isActive(tECarpentersBlock) ? (n2 == 0 ? 15 : 0) : (n2 == 1 ? 15 : 0);
    }

    private void notifySideNeighbor(ozlu ozlu2, int n, int n2, int n3, int n4) {
        ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
        switch (n4) {
            case 0: {
                ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
                break;
            }
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
    public void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        if (this.isActive(tECarpentersBlock)) {
            ozlu2.func_72898_h(n, n2, n3, this.field_71990_ca);
            int n6 = BlockProperties.getData(tECarpentersBlock);
            int n7 = Lever.getType(n6);
            switch (n7) {
                case 0: {
                    ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
                    break;
                }
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
                    break;
                }
                case 7: {
                    ozlu2.func_72898_h(n, n2 + 1, n3, this.field_71990_ca);
                }
            }
        }
    }

    @Override
    public boolean func_71853_i() {
        return true;
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersLeverRenderID;
    }
}

