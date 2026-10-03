/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Door;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class BlockCarpentersDoor
extends BlockBase {
    public BlockCarpentersDoor(int n) {
        super(n, tflj._d);
        this.func_71848_c(0.2f);
        this.func_71864_b("blockCarpentersDoor");
        this.func_111022_d("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = Door.getHinge(n);
        this.setDoorHinge(tECarpentersBlock, n2 == 0 ? 1 : 0);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        if (!entityPlayer.func_70093_af()) {
            if (!tECarpentersBlock.field_70331_k.field_72995_K) {
                int n3 = Door.getType(n2);
                if (++n3 > 5) {
                    n3 = 0;
                }
                this.setDoorType(tECarpentersBlock, n3);
            }
        } else {
            int n4;
            int n5 = n4 = Door.getRigidity(n2) == 0 ? 1 : 0;
            if (!tECarpentersBlock.field_70331_k.field_72995_K) {
                this.setDoorRigidity(tECarpentersBlock, n4);
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
        if (!this.activationRequiresRedstone(tECarpentersBlock)) {
            this.setDoorState(tECarpentersBlock, Door.getState(n5) == 1 ? 0 : 1);
        }
        return true;
    }

    private boolean activationRequiresRedstone(TECarpentersBlock tECarpentersBlock) {
        return Door.getRigidity(BlockProperties.getData(tECarpentersBlock)) == 1;
    }

    private List getDoorPieces(TECarpentersBlock tECarpentersBlock) {
        ArrayList<hurg> arrayList = new ArrayList<hurg>();
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = Door.getFacing(n);
        int n3 = Door.getHinge(n);
        int n4 = Door.getPiece(n);
        boolean bl = n4 == 1;
        arrayList.add(tECarpentersBlock);
        arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n));
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n - 1) == this.field_71990_ca ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n - 1) : null;
        TECarpentersBlock tECarpentersBlock3 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n + 1) == this.field_71990_ca ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n + 1) : null;
        TECarpentersBlock tECarpentersBlock4 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) == this.field_71990_ca ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) : null;
        TECarpentersBlock tECarpentersBlock5 = tECarpentersBlock.field_70331_k.func_72798_a(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) == this.field_71990_ca ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n) : null;
        switch (n2) {
            case 0: {
                int n5;
                if (tECarpentersBlock2 != null && n4 == Door.getPiece(n5 = BlockProperties.getData(tECarpentersBlock2)) && n2 == Door.getFacing(n5) && n3 == 1 && Door.getHinge(n5) == 0) {
                    arrayList.add(tECarpentersBlock2);
                    arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n - 1));
                }
                if (tECarpentersBlock3 == null || n4 != Door.getPiece(n5 = BlockProperties.getData(tECarpentersBlock3)) || n2 != Door.getFacing(n5) || n3 != 0 || Door.getHinge(n5) != 1) break;
                arrayList.add(tECarpentersBlock3);
                arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n + 1));
                break;
            }
            case 1: {
                int n6;
                if (tECarpentersBlock4 != null && n4 == Door.getPiece(n6 = BlockProperties.getData(tECarpentersBlock4)) && n2 == Door.getFacing(n6) && n3 == 0 && Door.getHinge(n6) == 1) {
                    arrayList.add(tECarpentersBlock4);
                    arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n));
                }
                if (tECarpentersBlock5 == null || n4 != Door.getPiece(n6 = BlockProperties.getData(tECarpentersBlock5)) || n2 != Door.getFacing(n6) || n3 != 1 || Door.getHinge(n6) != 0) break;
                arrayList.add(tECarpentersBlock5);
                arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n));
                break;
            }
            case 2: {
                int n7;
                if (tECarpentersBlock2 != null && n4 == Door.getPiece(n7 = BlockProperties.getData(tECarpentersBlock2)) && n2 == Door.getFacing(n7) && n3 == 0 && Door.getHinge(n7) == 1) {
                    arrayList.add(tECarpentersBlock2);
                    arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n - 1));
                }
                if (tECarpentersBlock3 == null || n4 != Door.getPiece(n7 = BlockProperties.getData(tECarpentersBlock3)) || n2 != Door.getFacing(n7) || n3 != 1 || Door.getHinge(n7) != 0) break;
                arrayList.add(tECarpentersBlock3);
                arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n + 1));
                break;
            }
            case 3: {
                int n8;
                if (tECarpentersBlock4 != null && n4 == Door.getPiece(n8 = BlockProperties.getData(tECarpentersBlock4)) && n2 == Door.getFacing(n8) && n3 == 1 && Door.getHinge(n8) == 0) {
                    arrayList.add(tECarpentersBlock4);
                    arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l - 1, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n));
                }
                if (tECarpentersBlock5 == null || n4 != Door.getPiece(n8 = BlockProperties.getData(tECarpentersBlock5)) || n2 != Door.getFacing(n8) || n3 != 0 || Door.getHinge(n8) != 1) break;
                arrayList.add(tECarpentersBlock5);
                arrayList.add(tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l + 1, tECarpentersBlock.field_70330_m - (bl ? 1 : -1), tECarpentersBlock.field_70327_n));
            }
        }
        return arrayList;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock;
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock = ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3) : null;
        if (tECarpentersBlock != null) {
            this.func_71902_a(ozlu2, n, n2, n3);
        }
        return super.func_71911_a_(ozlu2, n, n2, n3);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock;
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock = ozlu2.func_72798_a(n, n2, n3) == this.field_71990_ca ? (TECarpentersBlock)ozlu2.func_72796_p(n, n2, n3) : null;
        if (tECarpentersBlock != null) {
            this.func_71902_a(ozlu2, n, n2, n3);
        }
        return super.func_71872_e(ozlu2, n, n2, n3);
    }

    @Override
    public void func_71902_a(sdrg sdrg2, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)sdrg2.func_72796_p(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Door.getFacing(n4);
        int n6 = Door.getHinge(n4);
        boolean bl = Door.getState(n4) == 1;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        switch (n5) {
            case 0: {
                if (!bl) {
                    f3 = 0.1875f;
                    break;
                }
                if (n6 == 1) {
                    f2 = 0.8125f;
                    break;
                }
                f4 = 0.1875f;
                break;
            }
            case 1: {
                if (!bl) {
                    f4 = 0.1875f;
                    break;
                }
                if (n6 == 1) {
                    f3 = 0.1875f;
                    break;
                }
                f = 0.8125f;
                break;
            }
            case 2: {
                if (!bl) {
                    f = 0.8125f;
                    break;
                }
                if (n6 == 1) {
                    f4 = 0.1875f;
                    break;
                }
                f2 = 0.8125f;
                break;
            }
            case 3: {
                if (!bl) {
                    f2 = 0.8125f;
                    break;
                }
                if (n6 == 1) {
                    f = 0.8125f;
                    break;
                }
                f3 = 0.1875f;
            }
        }
        this.func_71905_a(f, 0.0f, f2, f3, 1.0f, f4);
    }

    public void setDoorState(TECarpentersBlock tECarpentersBlock, int n) {
        Iterator iterator2 = this.getDoorPieces(tECarpentersBlock).iterator();
        while (iterator2.hasNext()) {
            TECarpentersBlock tECarpentersBlock2;
            Door.setState(tECarpentersBlock2, n, (tECarpentersBlock2 = (TECarpentersBlock)iterator2.next()) == tECarpentersBlock);
        }
    }

    public void setDoorType(TECarpentersBlock tECarpentersBlock, int n) {
        Door.setType(tECarpentersBlock, n);
        this.updateAdjoiningDoorPiece(tECarpentersBlock);
    }

    public void setDoorRigidity(TECarpentersBlock tECarpentersBlock, int n) {
        for (TECarpentersBlock tECarpentersBlock2 : this.getDoorPieces(tECarpentersBlock)) {
            Door.setRigidity(tECarpentersBlock2, n);
        }
    }

    public void setDoorHinge(TECarpentersBlock tECarpentersBlock, int n) {
        Door.setHingeSide(tECarpentersBlock, n);
        this.updateAdjoiningDoorPiece(tECarpentersBlock);
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        boolean bl2 = bl = Door.getState(n5) == 1;
        if (Door.getPiece(n5) == 0) {
            if (ozlu2.func_72798_a(n, n2 + 1, n3) != this.field_71990_ca) {
                ozlu2.func_94571_i(n, n2, n3);
                return;
            }
            if (!ozlu2.func_72797_t(n, n2 - 1, n3)) {
                ozlu2.func_94571_i(n, n2 + 1, n3);
                return;
            }
        } else if (ozlu2.func_72798_a(n, n2 - 1, n3) != this.field_71990_ca) {
            ozlu2.func_94571_i(n, n2, n3);
            return;
        }
        boolean bl3 = false;
        for (TECarpentersBlock tECarpentersBlock2 : this.getDoorPieces(tECarpentersBlock)) {
            if (!ozlu2.func_72864_z(tECarpentersBlock2.field_70329_l, tECarpentersBlock2.field_70330_m, tECarpentersBlock2.field_70327_n)) continue;
            bl3 = true;
        }
        if (n4 > 0 && twgu.field_71973_m[n4].func_71853_i() && bl3 != bl) {
            this.setDoorState(tECarpentersBlock, bl ? 0 : 1);
        }
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return ItemHandler.itemCarpentersDoor.field_77779_bT;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return ItemHandler.itemCarpentersDoor.field_77779_bT;
    }

    private void updateAdjoiningDoorPiece(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = Door.getState(n);
        int n3 = Door.getHinge(n);
        int n4 = Door.getType(n);
        int n5 = Door.getRigidity(n);
        boolean bl = Door.getPiece(n) == 1;
        TECarpentersBlock tECarpentersBlock2 = bl ? (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m - 1, tECarpentersBlock.field_70327_n) : (TECarpentersBlock)tECarpentersBlock.field_70331_k.func_72796_p(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m + 1, tECarpentersBlock.field_70327_n);
        Door.setState(tECarpentersBlock2, n2, false);
        Door.setHingeSide(tECarpentersBlock2, n3);
        Door.setType(tECarpentersBlock2, n4);
        Door.setRigidity(tECarpentersBlock2, n5);
    }

    @Override
    public boolean func_71930_b(ozlu ozlu2, int n, int n2, int n3) {
        return n2 >= 255 ? false : ozlu2.func_72797_t(n, n2 - 1, n3) && super.func_71930_b(ozlu2, n, n2, n3) && super.func_71930_b(ozlu2, n, n2 + 1, n3);
    }

    @Override
    public int func_71857_b() {
        return BlockHandler.carpentersDoorRenderID;
    }
}

